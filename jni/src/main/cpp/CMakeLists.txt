# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("AndroidUse")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

# 创建并命名一个库，将其设置为STATIC或SHARED，并提供其源代码的相对路径。您可以定义多个库，而CMake会为您构建它们。
# Gradle会自动将共享库与您的APK打包在一起。
# 编译出一个动态库 helloJni，源文件只有 src/main/cpp/HelloJni.cpp
add_library( # Sets the name of the library.
        helloJni

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        HelloJni.cpp)

add_library( # Sets the name of the library.
        JniAndHeaderFile

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        JniAndHeaderFile.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

# 找到预编译库 log_lib 并link到我们的动态库 native-lib中
find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        helloJni

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})

target_link_libraries( # Specifies the target library.
        JniAndHeaderFile

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})