import re

def is_valid_insurance_id(id_string:str)->bool:
    
    if not re.match(r'^[A-Z]{3}-\d{5}-\d$', id_string):
        return False
    letters=id_string[0:3]
    digits=id_string[4:9]
    checksum=int(id_string[-1])  
    
    total=0
    
    for ch in letters:
        total+=ord(ch)-ord('A')+1
        
    for d in digits:
        total+=int(d)

    if total%10==checksum:
        return True
    else:
        return False


id_string = input("Enter Insurance ID: ")

if is_valid_insance_id := is_valid_insurance_id(id_string):
    print("True")
else:
    print("False")
    
    
