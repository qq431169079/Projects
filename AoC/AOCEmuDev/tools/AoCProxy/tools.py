#!/usr/bin/env python

import sys
from shared.packet import packet

compressed = False
if len(sys.argv) == 2 and sys.argv[1].upper() == 'TRUE':
    compressed = True
    
pkt = packet()
pkt.ReadFromBuffer(raw_input("packet hex dump : ").decode("hex"), compressed)

print
#print pkt.GetBuffer(False).encode("hex")
print pkt.opCode
print pkt.sender
print
print pkt.data.encode("hex")
