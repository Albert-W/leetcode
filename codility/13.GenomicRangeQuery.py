# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")


def solution(S, P, Q):
    # Implement your solution here
    res = []
    # m = {
    #     "A": 1,
    #     "C": 2,
    #     "G": 3,
    #     "T": 4
    # }
    # Prepare the data 
    # O(m * n)
    # data = []
    # for i in S:
    #     data.append(m[i])
    # for i in range(len(P)):
    #     res.append(min(data[P[i]: Q[i] + 1]))
    
    # The first column is all zeros 
    # sum_4 = [[0] * (len(S)+ 1)] * 4 
    sum_4 = [[0] * (len(S) + 1) for _ in range(4)] 
    for i in range(len(S)):
        sum_4[0][i+1] = sum_4[0][i] 
        sum_4[1][i+1] = sum_4[1][i]
        sum_4[2][i+1] = sum_4[2][i]
        sum_4[3][i+1] = sum_4[3][i]
        if S[i] == "A":
            sum_4[0][i+1] += 1
        if S[i] == "C":
            sum_4[1][i+1] += 1
        if S[i] == "G":
            sum_4[2][i+1] += 1
        if S[i] == "T":
            sum_4[3][i+1] += 1
    # print(sum_4)
    for i in range(len(P)):
        for j in range(4):
            if sum_4[j][Q[i] + 1] - sum_4[j][P[i]] > 0:
                res.append(j + 1)
                break
    # print(sum_4)
    return res 