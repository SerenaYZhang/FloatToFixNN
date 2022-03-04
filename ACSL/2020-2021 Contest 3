def createArrays(dim, inputArrays):
    output = []
    num = int(dim[-1])
    for arrayString in inputArrays:
        splitArrayString = arrayString.split()
        arrayList = []
        for row in range(0,int(dim[0])):
            rowList = []
            for column in range(row*num,(row+1)*num):
                rowList.append(int(splitArrayString[column]))
            arrayList.append(rowList)
        output.append(arrayList)
    return(output)

def get(inputArrays, row, column):
    numList = []
    for array in inputArrays:
        numList.append(array[row][column])
    return(numList)

def uniqueMax(List):
    newList = []
    repeatedNum = []
    for num in List:
        if num not in newList:
            newList.append(num)
        else:
            if num not in repeatedNum:
                repeatedNum.append(num)
    for num in repeatedNum:
        newList.remove(num)
    return(List.index(max(newList)))

def transverse(dim, arrays, location):
    numList = []
    locationList = []
    rowStart = location[0]
    rowEnd = location[0]+1
    columnStart = location[-1]
    columnEnd = location[-1]+1
    if location[0]>0:
        rowStart -= 1
    if location[0]<int(dim[0])-1:
        rowEnd += 1
    if location[-1]>0:
        columnStart -=1
    if location[-1]<int(dim[-1])-1:
        columnEnd += 1
    for element in arrays:
        for row in range(rowStart,rowEnd):
            for column in range(columnStart,columnEnd):
                if [row,column] != location:
                    numList.append(element[row][column])
                    locationList.append([row,column])
    return(locationList[uniqueMax(numList)])

def sumOfMinAlongPath(dim, arrays):
    arrays = createArrays(dim, arrays)
    if arrays == []:
        return(-1)
    location = [0,0]
    visitedLocation = []
    minSum = 0
    while location not in visitedLocation:
        visitedLocation.append(location)
        sumList = get(arrays,location[0],location[-1])
        minSum += min(sumList)
        location = transverse(dim, arrays, location)
    return(minSum)

a = ['6 2 7 4 6 1 5 7 5 6 7 8', '4 8 6 4 4 5 7 2 7 6 5 4', '3 6 9 2 4 8 2 6 3 2 1 4', '4 3 5 7 6 8 9 1 2 4 3 5']
print(createArrays("3 4",a))
print(sumOfMinAlongPath("3 4",a))

b = ["5 2 8 3 1 8 5 3 0 7 1 7 9 5 8 6","5 4 0 9 5 4 6 2 8 1 8 2 8 1 7 2","2 7 1 8 2 8 5 8 2 8 4 5 9 0 4 5"]
print(createArrays("4,4",b))
print(sumOfMinAlongPath("4,4",b))

c = ["1 2 3 5", "4 1 2 3", "2 5 3 8", "3 4 6 3"]
print(createArrays("2 2",c))
print(sumOfMinAlongPath("2 2",c))

six = ['11 12 13 14 15 16 17 18 19 20 11 12 13 14 15 16 17 18 19 20', '21 22 23 24 24 14 16 18 20 18 28 38 10 12 14 12 12 12 14 14', '12 11 23 13 15 25 17 27 19 29 11 11 13 13 15 15 17 17 19 19', '21 31 15 27 11 23 27 19 23 29 31 19 18 17 16 15 14 13 12 11']
print(createArrays("5 4",six))
print(sumOfMinAlongPath("5 4",six))

seven = ['-2 -1 -4 -1 -5 -9 -2 -6 -5 -3 -5 -4 -9 -7 -9 -3 -2 -3 -8 -4', '-6 -2 -6 -4 -3 -3 -8 -3 -2 -7 -1 -2 -4 -8 -4 -2 -1 -1 -3 -9', '-2 -4 -6 -8 -6 -5 -2 -3 -3 -5 -7 -9 -7 -5 -3 -5 -2 -3 -5 -7', '-4 -5 -2 -6 -9 -1 -3 -6 -8 -9 -1 -2 -5 -6 -2 -9 -6 -5 -3 -2', '-3 -1 -4 -1 -5 -9 -2 -6 -5 -3 -5 -8 -9 -7 -9 -3 -2 -3 -8 -4', '-6 -2 -6 -4 -3 -3 -8 -3 -2 -7 -3 -1 -8 -1 -5 -9 -2 -6 -5 -3', '-5 -8 -9 -7 -9 -3 -2 -3 -8 -4 -6 -2 -6 -4 -3 -3 -8 -3 -2 -7']
print(createArrays("4 5",seven))
print(sumOfMinAlongPath("4 5",seven))
