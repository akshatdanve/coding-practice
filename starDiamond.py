def star_diamond(n: int) -> None:
    for i in range(1, n+1):
        spaces = " " * (n - i)
        stars = "*" * (2*i-1)
        print(spaces+stars)
        
    for i in range(n,0,-1):
        spaces=" " * (n-i)
        stars = "*" * (2*i-1)
        print(spaces+stars)

# user input
n = int(input("Enter number of rows: "))
star_diamond(n)
