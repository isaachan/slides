import urllib.request
import os.path

f = open('jQuery-raw-output', 'r')

for name in f:
    name = name.strip()

    if name.startswith('#'):
        print("Not found {0}".format(name[1:]))
        continue

    full_name = "wiki_pages/{0}".format(name.replace("/", "_"))
    
    if os.path.isfile(full_name):
        print("skipped {0}".format(name))
        continue
        
    print("loading {0} ...".format(name))
    html = urllib.request.urlopen("https://en.wikipedia.org/wiki/{0}".format(name)).read()
    with open(full_name, 'w') as out:
        out.write(html.decode())

f.close()
