# MyEncryptionAndDecryptionAlgorithm

First, the key value is shifted 3 steps to the right. Then the plaintext is shifted 3 steps to the left. During these operations, mod26 is done. Then the new plaintext is shifted to the right as much as the new key value. Thus, encryption is performed. Then the new key value is extracted from this value. This value is also shifted 3 steps to the right and the decryption operation is performed successfully. The flowchart is shown in the file "flowchart.png".
