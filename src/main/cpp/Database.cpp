#include "Database.h"

#include <cppconn/driver.h>
#include <mysql_driver.h>

#include <iostream>

Database::Database(const std::string& host,
                   const std::string& user,
                   const std::string& password,
                   const std::string& dbName)
    : driver_(sql::mysql::get_mysql_driver_instance())
{
    try {
        connection_.reset(driver_->connect(host, user, password));
        connection_->setSchema(dbName);
    } catch (const sql::SQLException& exception) {
        std::cerr << "Error connecting to database: "
                  << exception.what() << std::endl;
        throw;
    }
}

Database::~Database() = default;

sql::Connection* Database::getConnection()
{
    return connection_.get();
}
