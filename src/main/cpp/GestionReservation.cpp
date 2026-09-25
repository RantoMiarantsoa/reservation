#include "Reservation.hh"
#include "GestionReservation.h"

#include <cppconn/prepared_statement.h>
#include <cppconn/resultset.h>

#include <memory>

BookingImpl::BookingImpl(Connection* conn) : conn_(conn) {}

BookingImpl::~BookingImpl() = default;

GestionReservation::ListeVols* BookingImpl::getListeVols()
{
    sql::Connection* connection = conn_->getConnection();
    std::unique_ptr<sql::PreparedStatement> statement(
        connection->prepareStatement(
            "SELECT numero_vol AS idVol, compagnie AS companie, "
            "lieu_depart AS lieuDepart, lieu_arrivee AS lieuArrivee, "
            "date_depart AS dateDepart, date_arrivee AS dateArrivee, "
            "prix_base AS prixBase "
            "FROM vol"
        )
    );
    std::unique_ptr<sql::ResultSet> result(statement->executeQuery());

    auto* listeVols = new GestionReservation::ListeVols();
    _CORBA_ULong index = 0;
    while (result->next()) {
        listeVols->length(index + 1);
        GestionReservation::Vol& vol = (*listeVols)[index++];
        vol.idVol = CORBA::string_dup(result->getString("idVol").c_str());
        vol.companie = CORBA::string_dup(
            result->getString("companie").c_str()
        );
        vol.lieuDepart = CORBA::string_dup(
            result->getString("lieuDepart").c_str()
        );
        vol.lieuArrivee = CORBA::string_dup(
            result->getString("lieuArrivee").c_str()
        );

        vol.dateDepart = CORBA::string_dup(
            result->getString("dateDepart").c_str()
        );
        vol.dateArrivee = CORBA::string_dup(
            result->getString("dateArrivee").c_str()
        );
        vol.prixBase = result->getDouble("prixBase");
    }

    return listeVols;
}
