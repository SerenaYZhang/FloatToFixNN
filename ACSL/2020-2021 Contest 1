def decToHex(n):
    ''' converts decimal to hexadecimal
    takes int input of a base 10 number
    returns str output of a base 16 number '''
    hex = "0123456789ABCDEF"
    unit = n % 16
    tens = n // 16
    if tens == 0:
        return(hex[unit])
    return(decToHex(tens) + hex[unit])

def hexToDec(n):
    ''' converts hexadecimal to decimal
    takes str input of a base 16 number
    returns int output of a base 10 number '''
    hex = "0123456789ABCDEF"
    n = list(n)
    exponent = len(n) - 1
    dec = 0
    for digit in n:
        dec += hex.index(digit) * (16 ** exponent)
        exponent -= 1
    return(dec)

def addDigits(n):
    ''' adds the digits of a number
    takes str input of a base 16 number
    returns str output of a base 16 number '''
    digit = list(n)
    sum = 0
    for unit in digit:
        sum += hexToDec(unit)
    if len(digit) == 1:
        return(digit[0])
    else:
        return(addDigits(decToHex(sum)))
    
def sumOfLastRow(s, d, r):
    ''' finds the sum of the digits of the last row of the triangle
    s = starting number, d = increment, r = number of rows
    returns str output of a base 16 number '''
    hexList = []
    column = 1
    increment = 0
    for i in range(r):
        decRow = []
        hexRow = []
        for j in range(column):
            decRow.append(hexToDec(s) + hexToDec(d) * increment)
            increment += 1
        for num in decRow:
            hexRow.append(decToHex(num))
        hexList.append(hexRow)
        column += 1
    return(addDigits(hexList[-1]))

print(sumOfLastRow("184", "231", 35))
