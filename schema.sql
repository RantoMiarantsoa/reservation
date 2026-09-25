-- schema_vol.sql
-- Structure MySQL : reservation de places d'avion uniquement
-- (version simplifiee du modele multi-services)

-- ---------------------------------------------------------------------
-- 1. UTILISATEUR (passager)
-- ---------------------------------------------------------------------
CREATE TABLE utilisateur (
    id_utilisateur INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100)
);

-- ---------------------------------------------------------------------
-- 2. VOL (remplace service + session_service, fusionnes en un seul objet)
-- ---------------------------------------------------------------------
CREATE TABLE vol (
    id_vol INT AUTO_INCREMENT PRIMARY KEY,
    numero_vol VARCHAR(20) NOT NULL,        -- ex: MD450
    compagnie VARCHAR(100) NOT NULL,        -- ex: Madagascar Airlines
    lieu_depart VARCHAR(150) NOT NULL,
    lieu_arrivee VARCHAR(150) NOT NULL,
    date_depart DATETIME NOT NULL,
    date_arrivee DATETIME NOT NULL,
    prix_base DECIMAL(10,2) NOT NULL,
    statut ENUM(
        'DISPONIBLE',
        'COMPLET',
        'ANNULE',
        'TERMINE'
    ) DEFAULT 'DISPONIBLE'
);

-- ---------------------------------------------------------------------
-- 3. SIEGE (place a bord d'un vol)
-- ---------------------------------------------------------------------
CREATE TABLE siege (
    id_siege INT AUTO_INCREMENT PRIMARY KEY,
    id_vol INT NOT NULL,
    numero_siege VARCHAR(10) NOT NULL,      -- ex: 12A
    classe ENUM(
        'ECONOMIQUE',
        'BUSINESS',
        'PREMIERE'
    ) DEFAULT 'ECONOMIQUE',
    prix DECIMAL(10,2) NOT NULL,
    statut ENUM(
        'LIBRE',
        'BLOQUE',
        'RESERVE'
    ) DEFAULT 'LIBRE',
    version INT DEFAULT 0,                  -- pour la concurrence optimiste
    FOREIGN KEY (id_vol)
        REFERENCES vol(id_vol),
    UNIQUE(id_vol, numero_siege)
);

-- ---------------------------------------------------------------------
-- 4. RESERVATION
-- ---------------------------------------------------------------------
CREATE TABLE reservation (
    id_reservation INT AUTO_INCREMENT PRIMARY KEY,
    reference VARCHAR(50) UNIQUE NOT NULL,
    id_utilisateur INT NOT NULL,
    id_vol INT NOT NULL,
    date_reservation DATETIME DEFAULT CURRENT_TIMESTAMP,
    montant_total DECIMAL(10,2) NOT NULL,
    statut ENUM(
        'EN_ATTENTE',
        'CONFIRMEE',
        'ANNULEE',
        'EXPIREE'
    ) DEFAULT 'EN_ATTENTE',
    FOREIGN KEY (id_utilisateur)
        REFERENCES utilisateur(id_utilisateur),
    FOREIGN KEY (id_vol)
        REFERENCES vol(id_vol)
);

-- ---------------------------------------------------------------------
-- 5. RESERVATION_SIEGE (une reservation peut couvrir plusieurs sieges)
-- ---------------------------------------------------------------------
CREATE TABLE reservation_siege (
    id_reservation_siege INT AUTO_INCREMENT PRIMARY KEY,
    id_reservation INT NOT NULL,
    id_siege INT NOT NULL,
    prix DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_reservation)
        REFERENCES reservation(id_reservation),
    FOREIGN KEY (id_siege)
        REFERENCES siege(id_siege),
    UNIQUE(id_reservation, id_siege)
);

-- ---------------------------------------------------------------------
-- 6. PAIEMENT (simule)
-- ---------------------------------------------------------------------
CREATE TABLE paiement (
    id_paiement INT AUTO_INCREMENT PRIMARY KEY,
    id_reservation INT NOT NULL,
    reference_paiement VARCHAR(50) UNIQUE,
    montant DECIMAL(10,2) NOT NULL,
    mode_paiement ENUM(
        'CARTE',
        'MOBILE_MONEY',
        'SIMULATION'
    ) DEFAULT 'SIMULATION',
    date_paiement DATETIME DEFAULT CURRENT_TIMESTAMP,
    statut ENUM(
        'EN_ATTENTE',
        'ACCEPTE',
        'REFUSE',
        'REMBOURSE'
    ) DEFAULT 'EN_ATTENTE',
    FOREIGN KEY (id_reservation)
        REFERENCES reservation(id_reservation)
);

-- ---------------------------------------------------------------------
-- Index utiles
-- ---------------------------------------------------------------------
CREATE INDEX idx_siege_vol_statut ON siege(id_vol, statut);
CREATE INDEX idx_reservation_utilisateur ON reservation(id_utilisateur);
CREATE INDEX idx_reservation_vol ON reservation(id_vol);
CREATE INDEX idx_paiement_reservation ON paiement(id_reservation);

-- ---------------------------------------------------------------------
-- Donnees de demo
-- ---------------------------------------------------------------------
INSERT INTO vol (numero_vol, compagnie, lieu_depart, lieu_arrivee, date_depart, date_arrivee, prix_base) VALUES
    ('MD450', 'Madagascar Airlines', 'Antananarivo', 'Paris', '2026-09-25 10:00:00', '2026-09-25 21:00:00', 1200000);

INSERT INTO siege (id_vol, numero_siege, classe, prix, statut) VALUES
    (1, '1A',  'BUSINESS',   2500000, 'LIBRE'),
    (1, '1B',  'BUSINESS',   2500000, 'LIBRE'),
    (1, '15A', 'ECONOMIQUE', 1200000, 'LIBRE'),
    (1, '15B', 'ECONOMIQUE', 1200000, 'LIBRE');