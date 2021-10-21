
 PAYMENT MODULE : Pay10
---------------------------
	Pay10 JAVA API
	
	    INSTALLATION PROCEDURE
	  --------------------------
	  
	  - Extract the zip file 
	  - Add both the jar files to the build path.
	  - Prepare the parameters as per the integration document in a map
	  - import com.pay.commons.crypto.ChecksumUtils in the class where the checksum needs to be generated
      - For generateing request checksum use:
	     ChecksumUtils.generateCheckSum(Map<String,String>, String secretKey) function which returns checksum String.
	  - For validating response checksum use:
		ChecksumUtils.validateResponseChecksum((Map<String,String>, String secretKey, String responseHash) function which returns true or false according to the result.

  
