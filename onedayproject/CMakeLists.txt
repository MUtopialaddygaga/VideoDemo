#set cmake version
cmake_minimum_required(VERSION 3.4.1)

#C 的编译选项是 CMAKE_C_FLAGS
# 指定编译参数，可选
SET(CMAKE_CXX_FLAGS "-Wno-error=format-security -Wno-error=pointer-sign")

#设置生成的so动态库最后输出的路径
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})

#设置头文件搜索路径（和此txt同个路径的头文件无需设置），可选
INCLUDE_DIRECTORIES(${PROJECT_SOURCE_DIR}/src/main/jni/)

#指定用到的系统库或者NDK库或者第三方库的搜索路径，可选。
#LINK_DIRECTORIES(/usr/local/lib)

#add_library( # Specifies the name of the library.
#             # 这里是你so的名字。刚才在 MainActivity里面要引用的
#             # 生成的so库名称，此处生成的so文件名称是libnative-lib.so
#             Hello
#
#             # Sets the library as a shared library.
#             # STATIC：静态库，是目标文件的归档文件，在链接其它目标的时候使用
#             # SHARED：动态库，会被动态链接，在运行时被加载
#             # MODULE：模块库，是不会被链接到其它目标中的插件，但是可能会在运行时使用dlopen-系列的函数动态链接
#             SHARED
#
#             # Provides a relative path to your source file(s).
#             # 这里是刚才 创建的c++ 代码的名字
#             # 资源文件，可以多个，
#             # 资源路径是相对路径，相对于本CMakeLists.txt所在目录
#        ${PROJECT_SOURCE_DIR}/src/main/jni/Hello.cpp)

add_library(
        JniInterface

        SHARED

        ${PROJECT_SOURCE_DIR}/src/main/jni/JniInterface.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              # android系统每个类型的库会存放一个特定的位置，而log库存放在log-lib中
               log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              # android系统在c环境下打log到logcat的库
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

# 配置库的链接（依赖关系）
target_link_libraries( # Specifies the target library.
              # 这里是你so的名字。刚才在 MainActivity里面要引用的 一样。
              #Hello
              JniInterface

              # Links the target library to the log library
              # included in the NDK.
              ${log-lib} )

