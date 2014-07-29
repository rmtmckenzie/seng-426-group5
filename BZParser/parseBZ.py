#!/usr/bin/python

import xml.etree.ElementTree as ET
from datetime import datetime, date
from os import linesep

def chunks(l, n):
    """ Yield successive n-sized chunks from l.
    """
    for i in xrange(0, len(l), n):
        yield l[i:i+n]

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
        elif el.tag == 'short_desc':
            cdata['description'] = ''.join(el.text,).encode("utf-8")
        elif el.tag == 'bug_severity':
            cdata['severity'] = el.text
        elif el.tag == 'resolution':
            cdata['resolution'] = el.text
        elif el.tag == 'bug_id':
            cdata['id'] = el.text
    bugs.append(cdata)

bugs = sorted(bugs,key=lambda bug: bug['cday'])

print "ID   Open Date    Created By         Close Date   Status       Severity"
print "-----------------------------------------------------------------------"
#for bug in (x for x in bugs if x['resolution'] != 'FIXED'):
#    status = 'Closed on '+ bug['mday'] if bug['status'] == 'RESOLVED' else 'Open'
for bug in bugs:
    print "{0: <4} {1}   {2: <18} {3: <12} {4: <12} {5}".format(bug['id'], bug['cday'], bug['reporter'], bug['mday'], bug['resolution'], bug['severity'])
    
    desc = bug['description'].split(' ')
    s = '  ';
    for d in desc:
        if len(s) + len(d) > 65:
            print s
            s = '  '
        s = ' '.join((s,d))
    print s
    print ''
    

