#pragma once

#include <memory>
#include <string>

#include <cppconn/connection.h>

class Database
{
private:
    sql::Driver* driver_;
    std::unique_ptr<sql::Connection> connection_;

public:
    Database(
        const std::string& host,
        const std::string& user,
        const std::string& password,
        const std::string& database
    );

    ~Database();

    sql::Connection* getConnection();
};
