# 当前路径
LOCAL_PATH := $(call my-dir)

# 清除LOCAL_XXX变量
include $(CLEAR_VARS)
# 打印日志
LOCAL_LDLIBS :=-llog

# 原生库名称
LOCAL_MODULE := Hello

# 原生代码文件
LOCAL_SRC_FILES =: Hello.cpp

# 编译动态库
include $(BUILD_SHARED_LIBRARY)
