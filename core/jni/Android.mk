LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := neoscrypt
LOCAL_SRC_FILES := com_crypto_algo_neoscrypt_hasher.c

include $(BUILD_SHARED_LIBRARY)