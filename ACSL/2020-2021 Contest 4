def stringToList(edges):
    List = []
    for i in range(0,len(edges),3):
        subList = [int(edges[i]), int(edges[i+1])]
        List.append(subList)
    return(List)

def sumEdges(num,paths):
    sumPaths = 0
    for path in paths:
        a = num
        for vertex in path:
            sumPaths += vertex * 10**a
            a -= 1
    return(sumPaths)

def sumPathsOfLengthN(num, edges):
    edges = stringToList(edges)
    allPaths = []
    for i in range(1,max(edges)[0]+1):
        start = i
        paths = [[start]]
        for j in range(num):
            nextLevelPaths = []
            for index in range(len(paths)):
                path = paths[index]
                end = path[-1]
                neighbors = []
                for edge in edges:
                    if edge[0]==end and edge[-1] not in path:
                        neighbors.append(edge[-1])
                for neighbor in neighbors:
                    newPath = path + [neighbor]
                    nextLevelPaths.append(newPath)
            paths = nextLevelPaths
        for k in paths:
            if len(k)==num+1:
                allPaths.append(k)
    return(sumEdges(num, allPaths))

edges = "12 23 34 41 31"
#print(stringToList(edges))
#print(sumPathsOfLengthN(2, edges))

graph = {"a":["b"], 
         "b":["c","d","e"], 
         "c":["d","e"], 
         "d":["a","e"], 
         "e":["f"], 
         "f":[], 
         "g":["d"]}

def pathDFS(num, graph, path, allPaths):
  if num==0:
    allPaths.append(path)
    return
  vertex = path[-1]
  neighbors = graph[vertex]
  for neighbor in neighbors:
    if neighbor not in path:
      pathDFS(num-1, graph, path+[neighbor], allPaths)

allPaths = []
for vertex in graph.keys():
  pathDFS(3, graph, [vertex], allPaths)
for path in allPaths:
  print(path)
