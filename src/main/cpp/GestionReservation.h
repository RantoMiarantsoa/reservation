#pragma once
#include "Connection.h"
#include "Reservation.hh" // En-tête généré par le compilateur IDL[cite: 1]
#include <string>


class BookingImpl : public POA_GestionReservation::Booking {
private:
    Connection* conn_; // Stockage du pointeur vers votre objet de connexion[cite: 1]

public:
    // Constructeur : reçoit le pointeur vers la connexion créée dans le main[cite: 1]
      explicit BookingImpl(Connection* conn);
    virtual ~BookingImpl();



    GestionReservation::ListeVols* getListeVols() override;



};