
import matplotlib.pyplot as plt
from numpy import *


with open("languages_result.txt") as file:
    content = file.readlines()
    content = [a for a in [l.strip('\n').split(' ') for l in content] if a[1] != 'NotFound']
    years_all = map(lambda x: x[1], content)
    years = list(set(years_all))
    years.sort()
    years_count = array([years_all.count(y) for y in years])
    fig = plt.figure(1, figsize=(16, 10))
    plt.bar(arange(len(years))+1, years_count, width=0.75)
    plt.xlabel('Year')
    plt.ylabel('Number of languages')
    plt.title('Number Of Languages Per Year', bbox={'facecolor': '0.8', 'pad': 5})
    plt.xticks(arange(len(years))+1, array(years), rotation=45)
    plt.savefig("fig01.png")
    plt.show()
