def order(s):
    numbers = ["0","1","2","3","4","5","6","7","8","9"]
    alphabet = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    num = []
    alph = []
    for char in s:
        if char in numbers:
            num.append(int(char))
        elif char in alphabet:
            alph.append(char)
    string = ""
    for char in sorted(num):
        string += str(char)
    for char in sorted(alph):
        string += char
    return(string)

def sort(s):
    c = 1
    output = []
    while s!="":
        List = []
        for index in range(0,len(s)-c):
            if s[index]!=s[index-1] and s[index]!=s[index+c]:
                List.append(s[index])
        if len(s)==c:
            List.append(s[0])
        elif s[-1]!=s[-1-c]:
            List.append(s[-1])
        if List!=[]:
            output.insert(0,List)
        for letter in List:
            s = s.replace(letter,"")
        c += 1
    return(output)

def reverse(l):
    for index in range(1,len(l),2):
        List = []
        for char in l[index]:
            List.insert(0,char)
        l[index] = List
    return(l)

def listToString(l):
    s = ""
    for char in l:
        s += char
    return(s)

def rearrangedString(s):
    rearranged = reverse(sort(order(s)))
    final = ""
    for l in rearranged:
        appear = 0
        for index in range(0,len(s)):
            if l[0]==s[index]:
                appear += 1
        string = ""
        for char in l:
            string += char
        final = final + str(appear) + string + ","
    return(final[:-1])

s = "123asdffgghhjjjkkklllzzzzmmmmxxxxx"
d = "This is an Example of Sorting an interesting string"
print(rearrangedString(d))
