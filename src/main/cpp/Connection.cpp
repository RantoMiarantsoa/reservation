#include "Connection.h"

Connection::Connection(const std::string& host,
                       const std::string& user,
                       const std::string& password,
                       const std::string& database)
    : database_(host, user, password, database)
{
}

sql::Connection* Connection::getConnection()
{
    return database_.getConnection();
}
