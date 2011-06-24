from ..common import packet
from construct import *

class onAuthenticate2:
    def __init__(self, handler, ipkt):
        # Parsing packet
        AuthenticateStruct = Struct("Authenticate",
            UBInt32("small_account_id"),
            UBInt32("cookie"),
            PascalString("GameClientVersionString", length_field = UBInt16("length")),
        )
        
        AuthenticateData = AuthenticateStruct.parse(ipkt.data)
        
        # Getting Infos from DataBase
        handler.server.db.query("SELECT * FROM `accounts` WHERE `account_id` = '%s'" % (AuthenticateData.small_account_id))
        r = handler.server.db.store_result()
        self.m_playerInfos = r.fetch_row(1, how=1)[0]
        
        if self.m_playerInfos["cookie"] == str(AuthenticateData.cookie):
            print "Player world authentification success for : %s" % (self.m_playerInfos["username"])
            handler.m_playerInfos = self.m_playerInfos
            handler.m_playerInfos["PlayerInstance"] = AuthenticateData.small_account_id
            
            # Report Dimension ID
            opkt = packet.Packet(handler, 0x0d, "Game")
            opkt.append_uint32(1)
            opkt.commit()            
            
            # Report Server ID
            opkt = packet.Packet(handler, 0x0e, "Game")
            opkt.append_uint32(1) #Server ID
            opkt.append_uint32(1) #Server Index
            opkt.commit()
            
            # AckAuthenticate
            opkt = packet.Packet(handler, 0x02, "Game")
            opkt.append_uint32(1)
            opkt.commit()
            
            # PassBlob :/
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("0000006a5c391c0000009c5000158af900438200000000000043910000620000c79e00000fa000000000000000000000000200009c5000158af90000c77d000000010000c77d0000000100000001000000010000000000000000ffffffffffffffff00000007000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000001bf271b3a6b0000c3500001559d003f080acac300158af94385599a40bd97964392cccd0000000000000000000000003f800000000006000e4d616c652054656d706c617465001000000101000001000030c801000000000000000000000000000000000000000000000000000000000000000fa000000fa000000fa000000fa00100000000000000010200000a7700001405010400000000000000000100010fa000000fa00032000224270064000000000000006400000000000000120000000000000000000000000000000200000002ec3b000003f1010000000200000010003a1185003a118500000001343432500ea16f5ede3daa401ef8a19aa90c6a590ea16f5ede3daa401ef8a19aa90c6a590000001200334b1500334b150000000143555035dd60bf99760973f67949edca8dedc7d2dd60bf99760973f67949edca8dedc7d200000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000002a00000000000000000000000000000000000003f1000000040000006f00000000000000000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("00000244271b3a6b0000c3500001559f003f080acac300158af943853016411e9f1c439e9c57000000003dda1555000000003e7e8b5d00000e000f5374796769616e20536c61766572001000000104000001000030c801000000000000000000000000000000000000000000000000000000000000000fa000000fa000000fa000000fa001000000030000000102000003cb00000f0a050400000000000000000100010fa000000fa00032000224260064000000000000006400000000000000120000000000000000000000000000000200000002ec3e000003f101000000040000000b0004634300046343000000015a39494dcc1e2c06ecf6161be5ecb5cbac912c59cc1e2c06ecf6161be5ecb5cbac912c590000000e0002e8350002e835000000014d5243544c29c2165cdf262d63c432492d7680884c29c2165cdf262d63c432492d768088000000100004634000046340000000015053594e40c16840b8bf432c3212bf2ee397ce5b40c16840b8bf432c3212bf2ee397ce5b000000120002187b0002187b0000000148463459a8d805fa3222563c9d7819f458c48c48a8d805fa3222563c9d7819f458c48c4800000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000002a00000000000000000000000000000002000003243f50394d000000000000000003433f4897d7000000000000000003f1000000010000000300000000000000000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("00000244271b3a6b0000c3500001559f003f080acac300158af943853016411e9f1c439e9c57000000003dda1555000000003e7e8b5d00000e000f5374796769616e20536c61766572001000000104000001000030c801000000000000000000000000000000000000000000000000000000000000000fa000000fa000000fa000000fa001000000030000000102000003cb00000f0a050400000000000000000100010fa000000fa00032000224260064000000000000006400000000000000120000000000000000000000000000000200000002ec3e000003f101000000040000000b0004634300046343000000015a39494dcc1e2c06ecf6161be5ecb5cbac912c59cc1e2c06ecf6161be5ecb5cbac912c590000000e0002e8350002e835000000014d5243544c29c2165cdf262d63c432492d7680884c29c2165cdf262d63c432492d768088000000100004634000046340000000015053594e40c16840b8bf432c3212bf2ee397ce5b40c16840b8bf432c3212bf2ee397ce5b000000120002187b0002187b0000000148463459a8d805fa3222563c9d7819f458c48c48a8d805fa3222563c9d7819f458c48c4800000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000002a00000000000000000000000000000002000003243f50394d000000000000000003433f4897d7000000000000000003f1000000010000000300000000000000000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("0000018c271b3a6b0000c3500001559b003f000acac300158af94383772b40c07787438c7c29000000003f7cd925000000003e20305d00000f000f5374796769616e2046656d616c65001000000103000001000030c801000000000000000000000000000000000000000000000000000000000000000fa000000fa000000fa000000fa00000000000000000010200000a7400001405010400000000000000000100010fa000000fa0003200021923005a0000000000000064000000000000001200000000000000000000000000000002000000032773000003f101000000010000000500019d7400019d7400000001385238493357a3d94d972fbc5f9549b7b7272d413357a3d94d972fbc5f9549b7b7272d4100000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003f1000000030000006f00000000000000000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("00000184271b3a6b0000c3500001559c003f000acac300158af94383c1ec40d17539438e4aa00000000000000000000000003f80000000000e0007536164647572001000000100000001000030c801000000000000000000000000000000000000000000000000000000000000000fa000000fa000000fa000000fa00000000003000000010200000bb100000f0a050400000000000000000100010fa000000fa000320031f5a30069000000000000006400000000000000120000000000000000000000000000000200000031f5b0000003f10100000001000000060003fc360003fc360000000552465150f2f9a557ea01340440322f6a3d622844f2f9a557ea01340440322f6a3d62284400000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003f1000000020000012c00000000000000000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000001f5271b3a6b0000c3500001559e003f000acac300158af94384299a40c06c60438a8e980000000000000000000000003f800000000007001046656d616c652054656d706c617465001000000101000001000030c801000000000000000000000000000000000000000000000000000000000000000fa000000fa000000fa000000fa00000000000000000010200000a7800001405010400000000000000000100010fa000000fa00032000047850064000000000000006400000000000000120000000000000000000000000000000200000003228a000003f10100000003000000050004f1e30004f1e3000000014c53474f993a59bc026929137a5f54cf9d473da9993a59bc026929137a5f54cf9d473da9000000100004f24c0004f24c000000013041594b95a39b79aabccc124d3c1657a19fa06395a39b79aabccc124d3c1657a19fa0630000001200334b1500334b150000000143555035dd60bf99760973f67949edca8dedc7d2dd60bf99760973f67949edca8dedc7d200000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003f1000000050000006f00000000000000000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c73c014b6e0000c878000155890043857917411e434243912f5c000000003f03d988000000003f5b6f4c00030f6c000f6a190000000000000000bf0d454abc99971ebf1346f43f02986240015b503f0d99d83f8000000000000000158af900000000001a343030305f7374796769616e5f67756172645f6c6f6f6b6f757400257e23212128552621223f705f21212121213c365c3324556d41615b442251544f5f4b585c27000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001558a004382fac140c0b9f543916e350000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512a7221212121213e62374d68702e446d402a3559434e2c286b2349000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001558b004382ef9e40c1525443948a5e0000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512a742121212121616f31564d586441516739272c4e4b3260622a41000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001558c0043823d2f40d871764394fac10000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b212121212121306764403c4f70455f2e3b384f615e275b456258000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()

            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001558d00438249db40d92aed4391c1ec0000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b23212121212163444d2f4c262a253561536e564e4a3b4222624a000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000b73c014b6e0000c8780001558e0043824b4440db6fbd43928e350000000000000000000000003f800000000203bc000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000000a6c6566745f726f77657200257e2321212855262121512b3221212121215f445a3c26674d48632454285e38406b2a324f33000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000b73c014b6e0000c8780001558f004382ff3b40c3dbcb439093960000000000000000000000003f800000000203bc000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000000a6c6566745f726f77657200257e2321212855262121512b352121212121465f522a226a2d2b74214667625d235936384b32000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001559000438619ba40d9eac8439d78520000000000000000000000003f80000000020834000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2421212121215d4d5b3868564e527236715c495555414539564f000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c87800015591004385f6c940d9d2b34398c8520000000000000000000000003f80000000020834000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b252121212121217248356b3e586b4e732c49446723595126426e000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c87800015592004385fae140d93001439a57f00000000000000000000000003f80000000020834000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2621212121213d3169646b656b6a64253f4c22486e6262246a3f000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c878000155930043854a1d40c2786c439874190000000000000000000000003f80000000020834000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b272121212121473b6b505f39597564472d6f3227243a756a4a6b000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c878000155940043860a1d40d8cfc0439beeb80000000000000000000000003f80000000020834000f6a190000000000000000bf40a460bc916037bfacdeaa3f51d8e7400b787e409192c93f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b282121212121432c2e45534334213a57534144423559683c5068000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c878000155950043824a1d40d9999a439a61480000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2a212121212160295a3332292b5d573958214a4e69253349453b000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c87800015596004382f9db40c055ef439889790000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2b2121212121277127403145594348422c4e5b5e4851396c2a53000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c878000155970043823cac40d9cbe64398d47b0000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2c21212121216d732f4b6630586f3529596467725460555d7126000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c87800015598004382460440d9faec43973b640000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2d21212121212d665b42295255556c2e373f69233d4b735d3042000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001559900438246a840d95825439677ae0000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e2321212855262121512b2e21212121213d566d4e58352d587338403e2b342b56593f3048000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000c03c014b6e0000c8780001559a0043824a1d40d9999a439a61480000000000000000000000003f80000000020835000f6a190000000000000000bf3ffac9bb84fe3dbfacdde73f51d846400b81d94091a98b3f8000000000000000158af900000000001353696d706c6544796e656c205b2d2d2d2d205d00257e232121285526212621384f21212121214458365335365d743d6c6f6d70522b582759232d000000000100000000000000000000000100000000000000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("000000255f52412e0000c3500d01f926014503b0000000000300011267485a2af13f8000003e4f4f3c".decode("hex"))
            opkt.commit()
            
            opkt = packet.Packet(handler, 0x00, "Game")
            opkt.append("0000035e293043490000c3500d01f92600000000150000000300000019000003f1000000180000000300000018000003f10000000300000030000003f10000000300000030000003f1000003f1000003f1000003f100000000000003f1000003f100004ae3000000070000000000000252000000000000025300000000000002540000000000000255000000000000000000000001000000e000000006000000ae00000002000000ad00000002000000bf000000000000040b000000000000000100001f400000001b00001f40000000360000000100000034000000000000015e000000640000003900000000000000a90000000000012f7d000000a50000006f000002410000000000000113000000020000001b00001f400000000100001f4000000328000003e8000001fa00000000000001fb00000000000001fa00000000000001f900001388000001f80000006400000324000003e80000004f000000000000000c00000000000000220000000000000006000000000000003b000000000000015e00000064000000390000000000000036000000010000004600000001000000330000000000000034000000000000000b000003e80000003a000000000000002100000003000001ae000000000000004b00000000000000d700000000000001850000000000000209000000000000025f3bc5b7c50000006a00000000000000f3000000000000043b0000000000000445000000000000043d000000000000043f000000000000008e000000000000033e000000000000033c000000000000008c000000000000008a00000000000000880000000000000139000000000000033a0000000000000338000000000000033200000000000003300000000000000334000000000000034400000000000003400000000000000443000000000000044100000000000003420000000000000336000000000000039d000000000000039b0000000000000398000000000000039a000000000000007f000000000000005b000000000000003c00000000000001c8000000000000014b000000000000003d00000000000002990000000000000298000000000000029700000000000002960000000000000295000000000000029400000000000002930000000000000292000000000000029100000000000002900000000000000000003e4f4f3c".decode("hex"))
            opkt.commit()
            
        else:
            print "Probably hacking attempt by : %s" % (self.m_playerInfos["username"])
            
            opkt = packet.Packet(handler, 0, "Game")
            opkt.append_uint32(0)
            opkt.commit()