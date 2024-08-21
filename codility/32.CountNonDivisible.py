# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution_TE(A):
    def get_divisors(n):
        divisors = set()
        for i in range(1, int(n**0.5)+1):
            if n % i == 0:
                divisors.add(i)
                divisors.add(n//i)
        return divisors
    l = len(A)
    if l == 1:
        return [0]
    res = [0] * l
    m = {} # To record the result, reduce the time
    count = {}
    for a in A:
        if a in count:
            count[a] += 1
        else:
            count[a] = 1
    for i in range(l):
        if A[i] in m:
            res[i] = m[A[i]]
        else:
            c = 0
            for j in get_divisors(A[i]):
                c += count.get(j, 0)
            res[i] = l - c
            m[A[i]] = l - c
    return res   

def solution_TE(A):
    def get_divisors(n):
        divisors = set()
        for i in range(1, int(n**0.5)+1):
            if n % i == 0:
                divisors.add(i)
                divisors.add(n//i)
        return divisors
    l = len(A)
    if l == 1:
        return [0]
    res = [0] * l
    
    count = {}
    for a in A:
        if a in count:
            count[a] += 1
        else:
            count[a] = 1
    for i in range(l):
        c = 0
        for j in get_divisors(A[i]):
            c += count.get(j, 0)
        res[i] = l - c
    return res    

def solution_TE(A):
    l = len(A)
    if l == 1:
        return [0]
    res = [0] * l
    
    count = {}
    for a in A:
        if a in count:
            count[a] += 1
        else:
            count[a] = 1
    for i in range(l):
        c = 0
        for j in range(1, int(A[i] ** 0.5) + 1):
            if A[i] % j == 0:
                c += count.get(j, 0)
                if j * j != A[i]:
                    c += count.get(A[i] // j, 0)
        res[i] = l - c
    return res
    

def solution_TE(A):
    # Implement your solution here
    l = len(A)
    if l == 1:
        return [0]

    res = [0] * l
    m = {} # To record the result, reduce the time
    for i in range(l):
        if A[i] in m:
            res[i] = m[A[i]]
        else: 
            count = 0
            for j in range(l):
                if A[i] % A[j] != 0:
                    count += 1
            res[i] = count
            m[A[i]] = count 

    return res 