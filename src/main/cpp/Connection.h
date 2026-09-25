#pragma once

#include <string>

#include <cppconn/connection.h>

#include "Database.h"

class Connection
{
private:
    Database database_;

public:
    Connection(
        const std::string& host = "localhost",
        const std::string& user = "root",
        const std::string& password = "",
        const std::string& database = "avion_corba"
    );

    sql::Connection* getConnection();
};
