from bs4 import BeautifulSoup
import urllib.request
import sys
import os

not_found = "NotFound"

def find_year_by_name(name):
    soup = BeautifulSoup(open("wiki_pages/{0}".format(name)), "lxml")
    table = soup.select('table.infobox')
    if len(table) == 0:
        return not_found
    table = table[0].text
    if table == None:
        return not_found
    
    table_content = str.encode(table).split(b'\n')
    for i in range(len(table_content)):
        if (table_content[i].decode() == "First appeared"):
            return table_content[i+1].decode().split(";")[0]
        
    return not_found


for name in os.listdir('wiki_pages'):
    print("{0} {1}".format(name, find_year_by_name(name)))

    
