LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := LyraZ
LOCAL_CFLAGS: = -Wall -g  -fPIC -shared
LOCAL_SRC_FILES := doMyLyraz.c blake.c  Lyra2.c Lyra2Z.c   Sponge.c
include $(BUILD_SHARED_LIBRARY)
