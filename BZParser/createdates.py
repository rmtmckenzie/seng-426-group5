#!/usr/bin/python

import xml.etree.ElementTree as ET
from datetime import datetime, date

filename = 'bugs.xml'

tree = ET.parse(filename)

root = tree.getroot()

bugs = []
for child in root:
    cdata = {}
    for el in child:
        if el.tag == 'creation_ts':
            tstring = el.text
            cdata['cday'] = tstring[:10]
        elif el.tag == 'delta_ts':
            tstring = el.text
            cdata['mday'] = tstring[:10]
        elif el.tag == 'reporter':
            cdata['reporter'] = el.attrib['name']
        elif el.tag == 'component':
            cdata['component'] = el.text
        elif el.tag == 'bug_status':
            cdata['status'] = el.text
        elif el.tag == 'resolution' and el.text:
            cdata['resolution'] = el.text
    bugs.append(cdata)

bugs = sorted(bugs,key=lambda bug: bug['cday'])

print "Created:"
for bug in bugs:
    status = 'Closed on '+ bug['mday'] if bug['status'] == 'RESOLVED' else 'Open'
    print "{0}  {1: <20} {2}".format(bug['cday'], bug['reporter'], status)


    

