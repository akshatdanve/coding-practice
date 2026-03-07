def fibonacci_triangle(n):
    a = 0
    b = 1
    
    for i in range(1, n+1):
        for j in range(i):
            print(a, end=" ")
            c = a + b
            a = b
            b = c
        print()


n = int(input("Enter number of rows: "))
fibonacci_triangle(n)
