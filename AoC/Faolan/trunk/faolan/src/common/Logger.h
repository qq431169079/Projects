/*
Faolan Project, a free Age of Conan server emulator made for educational purpose
Copyright (C) 2008 Project Faolan team

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

#ifndef LOGGER_H_
#define LOGGER_H_

#include <string>
#include <sstream>

class Logger {

public:

    /**
     * Change logger instance by a new one
     * @param logger logger instance
     */
    static void setLogger(Logger* logger);

    /**
     * C style message logging
     */
    static void log(const char* format, ...);

    /**
     * C++ style message logging
     */
    static Logger& log();
    template<class T> Logger& operator <<(const T& message);

    /**
     * Destructor
     */
    virtual ~Logger();

private:

    /**
     * pure virtual method to overload on each logger
     */
    virtual void write(const std::string& msg)=0;

    /**
     * Destroy the current logger instance
     */
    static void destroy();

    static Logger* m_loggerInstance;

};

template <class T> Logger& Logger::operator <<(const T& message)
{
    std::ostringstream stream;
    stream << message;
    write(stream.str());

    return log();
}

#endif /*LOGGER_H_*/
