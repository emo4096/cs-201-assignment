import sys
A
FILENAME = str(sys.argv[1])

result_list = []

with open(FILENAME, "r") as file:
    for line in file.readlines():
        line = line.strip()
        result_list.append(line.split(","))

result = "{\n"

for item in result_list:
    result += "{\""
    result += item[0]
    result += "\", \""
    result += item[1]
    result += "\"},\n"

result += "};"

print(result)
