LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := nessdb
LOCAL_C_INCLUDES := $(LOCAL_PATH)/engine
LOCAL_SRC_FILES := db_java.c \
	engine/block.c \
	engine/buffer.c \
	engine/db.c \
	engine/debug.c \
	engine/index.c \
	engine/meta.c \
	engine/quicklz.c \
	engine/sst.c \
	engine/xmalloc.c

include $(BUILD_SHARED_LIBRARY)
