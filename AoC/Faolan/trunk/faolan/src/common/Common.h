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

#ifndef COMMON_H_
#define COMMON_H_

#pragma warning(disable:4996)

#ifdef HAVE_CONFIG_H
# include <config.h>
#endif




// current platform and compiler
#define PLATFORM_WIN32 0
#define PLATFORM_UNIX  1
#define PLATFORM_APPLE 2

#if defined( __WIN32__ ) || defined( WIN32 ) || defined( _WIN32 )
#  define PLATFORM PLATFORM_WIN32
#  define WIN32_LEAN_AND_MEAN
#  define _WIN32_WINNT 0x0501
#elif defined( __APPLE_CC__ )
#  define PLATFORM PLATFORM_APPLE
#else
#  define PLATFORM PLATFORM_UNIX
#endif

#define COMPILER_MICROSOFT 0
#define COMPILER_GNU       1
#define COMPILER_BORLAND   2

#ifdef _MSC_VER
#  define COMPILER COMPILER_MICROSOFT
#elif defined( __BORLANDC__ )
#  define COMPILER COMPILER_BORLAND
#elif defined( __GNUC__ )
#  define COMPILER COMPILER_GNU
#else
#  pragma error "FATAL ERROR: Unknown compiler."
#endif

#if COMPILER == COMPILER_MICROSOFT
#  pragma warning( disable : 4267 ) // conversion from 'size_t' to 'int', possible loss of data
#  pragma warning( disable : 4786 ) // identifier was truncated to '255' characters in the debug information
#endif

#if PLATFORM == PLATFORM_WIN32
#define STRCASECMP stricmp
#else
#define STRCASECMP strcasecmp
#endif


#if COMPILER == COMPILER_GNU && __GNUC__ >= 3
#include <ext/hash_map>
#define __fastcall __attribute__((__fastcall__))
#else
#include <hash_map>
#endif



#ifdef _STLPORT_VERSION
#define HM_NAMESPACE std
#elif COMPILER == COMPILER_MICROSOFT && _MSC_VER >= 1300 // msvc71
#define HM_NAMESPACE stdext
#elif COMPILER == COMPILER_GNU && __GNUC__ >= 3
#define HM_NAMESPACE __gnu_cxx

namespace __gnu_cxx {
    template<> struct hash<unsigned long long> {
        size_t operator()(const unsigned long long &__x) const { return (size_t)__x; }
    };
    template<typename T> struct hash<T *> {
        size_t operator()(T * const &__x) const { return (size_t)__x; }
    };

};

#else
#define HM_NAMESPACE std
#endif

#if COMPILER == COMPILER_MICROSOFT
  typedef __int64   int64;
#else
  typedef long long int64;
#endif
typedef long        int32;
typedef short       int16;
typedef char        int8;

#if COMPILER == COMPILER_MICROSOFT
  typedef unsigned __int64   uint64;
#else
  typedef unsigned long long  uint64;
  typedef unsigned long      DWORD;
#endif
typedef unsigned long        uint32;
typedef unsigned short       uint16;
typedef unsigned char        uint8;

#if COMPILER == COMPILER_MICROSOFT

#define I64FMT "%016I64X"
#define I64FMTD "%I64u"
#define SI64FMTD "%I64d"
#define snprintf _snprintf
#define atoll __atoi64

#else

#define stricmp strcasecmp
#define strnicmp strncasecmp
#define I64FMT "%016llX"
#define I64FMTD "%llu"
#define SI64FMTD "%lld"

#endif

#define atol(a) strtoul( a, NULL, 10)

#define STRINGIZE(a) #a

#endif
