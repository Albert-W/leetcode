# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(plan):
    # Implement your solution here
    # Prepare the map 
    map = []
    for p in plan:
        map.append(list(p))
    # print(map)
    rows = len(plan)
    cols = len(plan[0])
    # print(rows, cols)
    # res = 0

    # mark will count the dirt room. 
    # 0 - visited. 
    # 1 - 1 room need to be clean. 
    def dfs(map, y, x, mark, found):
        if map[y][x] == '*':
            found[0] = True
        map[y][x] = mark
        
        # print("start", mark)
        if x + 1 < cols and (map[y][x + 1] == '.' or map[y][x + 1] == '*'):
            dfs(map, y, x+1, mark, found) 
        if x - 1 >=0 and (map[y][x - 1] == '.' or map[y][x - 1] == '*'):
            dfs(map, y, x-1, mark, found)
        if y + 1 < rows and (map[y + 1][x] == '.' or map[y + 1][x] == '*'):
            dfs(map, y + 1, x, mark, found)
        if y - 1 >= 0 and (map[y - 1][x] == "." or map[y -1][x] == "*"):
            dfs(map, y -1, x, mark, found) 
        # if found == True:
        #     mark +=1
    
    mark = 0
    count = 0
    
    for y in range(rows):
        for x in range(cols):
            if map[y][x] == '.' or map[y][x] == '*':
                found = [False] # pass a reference in 
                dfs(map, y, x, mark, found) 
                if found[0] == True:
                    mark += 1
                count += 1
    # print(map)
    # print(mark, count)
    return mark 
