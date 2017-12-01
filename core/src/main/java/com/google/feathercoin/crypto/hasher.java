
package com.google.feathercoin.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The wrapper around the original neoscrypt c-code
 * loads the native library passes program parameter to the c-code
 * and returns the result
 */
public class hasher {
   
    private static  boolean native_library_loaded = false;
    private static Logger log = LoggerFactory.getLogger(hasher.class);
    
        static {
           try {
                System.loadLibrary("neoscrypt");
                native_library_loaded = true;
            } catch (Throwable e) {
       //      log.error("native library neoscrypt not loaded" ,e);
            }
        }


    /**
     * calls the c- code
     * @parameters:
     * input: string to be hashed
     * profile: defines which hash algorithm to use
     *  - 0x3 : Scrypt
     *  - 0x80000620 : neoscrypt for feathercoin
     */
	public static byte[] getHash(byte[] input, int profile) {
        
		hasher neoScrypt = new hasher();
        byte[] output = new byte[32];


        if (native_library_loaded) {
/* Todo: is char the right data type to pass?

 */
            neoScrypt.neoscrypt(input, output, profile);
            log.warn ( "output: ", output);
            return neoScrypt.neoscrypt(input, output, profile);

        }
        return output;

	}

	private native byte[] neoscrypt(byte[] input,byte[] output,int profile);

}
