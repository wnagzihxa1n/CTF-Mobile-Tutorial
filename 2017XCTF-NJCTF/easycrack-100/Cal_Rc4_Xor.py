# coding = utf-8

import binascii

def main():
	key_rc4 = "I_am_the_key"
	rc4_encrypted = binascii.a2b_hex("C8E4EF0E4DCCA683088134F8635E970EEAD9E277F314869F7EF5198A2AA4")
	
	# Init rc4_key
	j = 0;
	s = range(256)
	for i in range(256):
		j = (j + s[i] + ord(key_rc4[i % len(key_rc4)])) % 256
		s[i], s[j] = s[j], s[i]
	i = 0
	j = 0
	
	# Rc4 decryption
	rc4_decrypted = []
	for data in rc4_encrypted:
		i = (i + 1) % 256
		j = (j + s[i]) % 256
		s[i], s[j] = s[j], s[i]
		rc4_decrypted.append(chr(ord(data) ^ s[(s[i] + s[j]) % 256]))
	rc4_decrypted =  "".join(rc4_decrypted)
	print rc4_decrypted

	key_xor = "V7D=^,M.E"
	key_xor_len = len(key_xor)
	Flag = []
	for i in range(len(rc4_decrypted)):
		 Flag.append(chr(ord(rc4_decrypted[i]) ^ ord(key_xor[i % key_xor_len])))
	print "".join(Flag)

if __name__ == '__main__':
	main()


	
