#include <iostream>
#include <fstream>
#include <exception>
#include <filesystem>

// En-têtes CORBA et BDD
#include "Reservation.hh"          // En-tête généré par idl
#include "GestionReservation.h"   // Votre classe servant
#include "Connection.h"            // Votre classe de connexion

int main(int argc, char* argv[]) {
    try{
//Initalisation ORB
        CORBA::ORB_var orb = CORBA::ORB_init(argc,argv);
        
        //  Récupération et activation du POA Racine
        //Maka RootPOA ilay POA principale no alaina
        CORBA::Object_var obj = orb->resolve_initial_references("RootPOA");
        //Avadika POA le obj eto grace a _narrow
        PortableServer::POA_var poa= PortableServer::POA::_narrow(obj);
        //COntrole l'etat du POA
        PortableServer::POAManager_var poaManager = poa->the_POAManager();
        poaManager->activate();

std::cout << "ORB et RootPOA initialisés avec succès !" << std::endl;
        Connection conn;
        conn.getConnection();
        

      BookingImpl* myServant = new BookingImpl(&conn);

        PortableServer::ObjectId_var myServantID = poa->activate_object(myServant);
        CORBA::Object_var ref = poa->id_to_reference(myServantID);

        CORBA::String_var ior = orb->object_to_string(ref);

        std::filesystem::create_directories("config");
        std::ofstream file("config/reservation.ior");

        if (file.is_open()) {
            file << ior << std::endl;
            file.close();
            std::cout << " Fichier 'reservation.ior' généré avec succès !" << std::endl;
        }

        std::cout << " Serveur CORBA démarré et en attente des requêtes..." << std::endl;

        orb->run();

        orb->destroy(); 
    }catch (const CORBA::Exception& e) {
        std::cerr << " Erreur CORBA : " << e._name() << std::endl;
    } catch (const std::exception& e) {
        std::cerr << " Erreur Standard : " << e.what() << std::endl;
    }

    return 0;


}