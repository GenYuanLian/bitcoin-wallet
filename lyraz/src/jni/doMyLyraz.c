#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <stdio.h>
#include <jni.h>
#include "sph_blake.h"
#include "Lyra2.h"
#include "Lyra2Z.h"
JNIEXPORT jbyteArray JNICALL Java_com_example_myapplication_ShaHash256_doLyraHash
			(JNIEnv *env,jobject c1,jbyteArray buffer,jint len)
{
	unsigned char input[len];
	unsigned char output[len];
	uint32_t hashA[8], hashB[8];

	(*env)->GetByteArrayRegion(env,buffer,0,len,input);
	sph_blake256_context     ctx_blake;
    sph_blake256_init(&ctx_blake);
    sph_blake256 (&ctx_blake, &input, 80);
    sph_blake256_close (&ctx_blake, &hashA);	
	
	LYRA2(&hashB, 32,hashA, 32, hashA, 32, 8, 8, 8);
	
	memcpy(&output, hashB, 32);
	int vl = sizeof(output)/sizeof(output[0]);
	jbyteArray array = (*env)->NewByteArray(env,vl);

	(*env)->SetByteArrayRegion(env,array,0,vl,output);
	//printf("zui hou di!\n");
	return array;

};


JNIEXPORT jbyteArray JNICALL Java_org_bitcoinj_core_Sha256Hash_doLyraHash
			(JNIEnv *env,jobject c1,jbyteArray buffer,jint len)
{
	unsigned char input[len];
	unsigned char output[len];
	uint32_t hashA[8], hashB[8];

	(*env)->GetByteArrayRegion(env,buffer,0,len,input);
	sph_blake256_context     ctx_blake;
    sph_blake256_init(&ctx_blake);
    sph_blake256 (&ctx_blake, &input, 80);
    sph_blake256_close (&ctx_blake, &hashA);

	LYRA2(&hashB, 32,hashA, 32, hashA, 32, 8, 8, 8);

	memcpy(&output, hashB, 32);
	int vl = sizeof(output)/sizeof(output[0]);
	jbyteArray array = (*env)->NewByteArray(env,vl);

	(*env)->SetByteArrayRegion(env,array,0,vl,output);
	//printf("zui hou di!\n");
	return array;

};