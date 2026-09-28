-- =====================================================
-- 竞赛详情数据填充脚本
-- 数据库: xm_sociation_platform
-- 说明: 为所有竞赛填充 background/history/culture/eligibility/tracks/resources/timeline 字段
-- 数据来源: 各竞赛官网及官方文件
-- =====================================================

-- =====================================================
-- 一、网络工程竞赛 (network, id=1~11)
-- =====================================================

-- 1. 华为ICT大赛 · 网络赛道
UPDATE `competition` SET
`background` = '随着全球数字化转型加速，ICT（信息与通信技术）人才缺口持续扩大。华为作为全球领先的ICT基础设施提供商，于2015年发起华为ICT大赛，旨在搭建国际化竞技和交流平台，推动校企合作与ICT人才培养。大赛以"联接、荣耀、未来"为主题，以"I. C. The Future"为口号，协同政府、高校、培训机构及行业企业，构建ICT人才生态链。2021年3月，大赛成功入围中国高等教育学会"全国普通高校大学生竞赛排行榜"，成为中国最具影响力的IT类学科竞赛之一。',
`history` = '2015年：首届华为ICT大赛举办，覆盖中国区少数高校\n2017年：大赛升级为全球性赛事，覆盖海外30+国家\n2019年：参赛国家突破60个，报名人数超10万\n2021年：入选中国高等教育学会"全国普通高校大学生竞赛排行榜"\n2023年：参赛覆盖全球80+国家，累计参赛人次超58万\n2024年：第九届大赛，被纳入UNESCO全球技能学院合作伙伴\n2025年：第十届大赛启航，新增基础软件赛道，赛事体系全面升级',
`culture` = '大赛以"联接、荣耀、未来"为核心价值理念。"联接"代表ICT技术连接万物、连接世界、连接未来的使命；"荣耀"代表每一位参赛者通过技术竞技收获的自信与成就感；"未来"代表ICT人才是驱动数字世界发展的核心力量。大赛倡导"以赛促学、以赛促教、以赛促就业"的育人理念，注重培养学生的实践动手能力、创新创造能力和团队协作能力。',
`eligibility` = '学历要求：全日制在校大学生（本科、高职均可），不限专业\n组队要求：实践赛个人参赛（省赛），国赛为3人团队赛；创新赛3-5人组队\n专业技能：\n  - 网络赛道：掌握路由交换基础（OSPF/BGP/VLAN/STP）、网络安全基础（ACL/NAT/VPN）、WLAN技术\n  - 建议持有HCIA-Datacom或同等水平认证\n  - 熟练使用eNSP模拟器进行网络实验',
`tracks` = '[{"name":"网络赛道","type":"professional","desc":"涵盖路由交换、网络安全、WLAN、广域网等核心技术，考察网络规划设计及故障排除能力","detailPage":""},{"name":"云赛道","type":"professional","desc":"聚焦云计算、云原生、大数据、存储等方向，考察云平台架构设计与运维能力","detailPage":""},{"name":"基础软件赛道","type":"professional","desc":"涵盖操作系统、数据库、中间件等基础软件技术，考察国产基础软件应用能力","detailPage":""},{"name":"昇腾AI赛道","type":"other","desc":"聚焦AI基础知识、昇腾全栈系统、模型训练与推理","detailPage":""},{"name":"创新赛","type":"comprehensive","desc":"学生提交软件或软硬一体化作品，具备社会效益和商业价值","detailPage":""},{"name":"编程赛","type":"comprehensive","desc":"考察算法设计与编程实现能力，使用C/C++/Java/Python等语言","detailPage":""}]',
`resources` = '[{"name":"华为ICT大赛2025-2026官方手册","url":"https://e.huawei.com/cn/material/enterprise/e.huawei.com/cn/documents/others/212464e4d94143deaad4b1ee7f9dc55f","type":"rule"},{"name":"华为ICT学院学习资源","url":"https://e.huawei.com/cn/talent/ict-academic","type":"notice"}]',
`timeline` = '[{"stage":"校赛","start":"2025年10月","end":"2025年11月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"省赛","start":"2025年11月","end":"2025年12月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"中国总决赛","start":"2026年2月","end":"2026年3月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"},{"stage":"全球总决赛","start":"2026年5月","end":"2026年5月","firstRatio":"仅3队","secondRatio":"—","thirdRatio":"—"}]'
WHERE `name` = '华为ICT大赛 · 网络赛道';

-- 2. 思科网络技术大赛
UPDATE `competition` SET
`background` = '思科系统公司（Cisco）是全球领先的网络解决方案提供商，其思科网络技术学院（Cisco Networking Academy）是全球规模最大的IT技能教育项目之一。为激发全球网络技术人才的学习热情，思科定期举办网络技术竞赛，通过Packet Tracer等仿真平台考察学生的网络设计与排错能力。比赛覆盖全球180+国家和地区，以CCNA/CCNP认证体系为核心知识框架。',
`history` = '1997年：思科网络技术学院项目正式启动\n2000年代：思科网院在中国大规模推广，与数百所高校合作\n2010年代：思科网院杯（APJC NetRiders）赛事在亚太区举办\n2023年：升级为思科NetAcad Riders全球竞赛\n2025年：EMEA地区推出全新思科Networking Academy Cup，覆盖110+国家',
`culture` = '思科网络技术大赛秉承"Bridge to Possible"（通往可能之桥）的理念，强调网络技术是连接世界的桥梁。大赛倡导"Learning by Doing"（做中学）的实践精神，通过模拟真实企业网络环境，让学生在竞技中掌握真正可用的职业技能。',
`eligibility` = '学历要求：全日制在校大学生\n组队要求：个人赛\n专业技能：\n  - 完成思科网院Networking Essentials或CCNA Module 1课程\n  - 掌握路由交换基础、VLAN/STP/EtherChannel、OSPF/EIGRP协议\n  - 熟练使用Cisco Packet Tracer模拟器\n  - 建议持有CCNA或同等水平认证',
`tracks` = '[{"name":"网络技术赛道","type":"professional","desc":"CCNA/CCNP核心知识，涵盖路由交换、网络安全、网络自动化","detailPage":""},{"name":"网络安全赛道","type":"professional","desc":"涵盖网络安全基础、CyberOps、威胁检测与防御","detailPage":""},{"name":"DevNet开发赛道","type":"other","desc":"考察Python编程、API调用、网络自动化开发能力","detailPage":""}]',
`resources` = '[{"name":"思科网络技术学院官网","url":"https://www.netacad.com/zh/","type":"notice"},{"name":"CCNA认证学习指南","url":"https://www.cisco.com/c/en/us/training-events/training-certifications/certifications/associate/ccna.html","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年3月","end":"每年5月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"亚太区竞赛","start":"每年6月","end":"每年7月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"全球总决赛","start":"每年8月","end":"每年8月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"}]'
WHERE `name` = '思科网络技术大赛';

-- 3. 全国大学生网络与信息安全竞赛 (CISCN)
UPDATE `competition` SET
`background` = '随着网络空间成为继陆、海、空、天之后的"第五空间"，网络安全上升为国家战略。教育部高等学校网络空间安全专业教学指导委员会于2008年发起全国大学生信息安全竞赛(CISCN)，旨在培养和选拔网络安全领域的优秀人才，推动高校网络空间安全学科建设。大赛入选国家级A类竞赛榜单，是国内网络安全领域规模最大、权威性最高的学科竞赛。',
`history` = '2008年：首届全国大学生信息安全竞赛举办\n2014年：增设创新实践能力赛（CTF赛制）\n2016年：引入AWD攻防对抗赛制\n2019年：参赛队伍突破1000支\n2021年：创新实践能力赛与"长城杯"铁人三项赛合并\n2025年：第十八届大赛，半决赛引入AWDP+ISW双赛制',
`culture` = 'CISCN以"没有网络安全就没有国家安全"为使命，弘扬"攻防相长、知行合一"的竞赛文化。比赛不仅是技术的较量，更是团队协作、临场应变和心理素质的综合考验。大赛注重培养"白帽子"精神——以合法合规的方式发现漏洞、修复漏洞，守护网络空间安全。',
`eligibility` = '学历要求：全日制在校大学生（本科、研究生均可）\n组队要求：4人组队参赛\n专业技能：\n  - Web安全：SQL注入、XSS、CSRF、文件上传、SSRF、反序列化\n  - PWN二进制：栈溢出、堆利用、格式化字符串、ROP链\n  - 逆向工程：反汇编、反编译、脱壳、算法逆向\n  - 密码学：古典密码、现代密码（RSA/AES）、攻击方法\n  - 杂项：流量分析、隐写术、取证分析',
`tracks` = '[{"name":"创新实践能力赛（CTF）","type":"professional","desc":"线上CTF解题赛+线下AWD攻防赛，涵盖Web/PWN/Reverse/Crypto/Misc五大方向","detailPage":""},{"name":"作品赛","type":"comprehensive","desc":"提交网络安全相关软件或硬件作品，需有创新性和实用性","detailPage":""}]',
`resources` = '[{"name":"CISCN大赛官网","url":"http://www.ciscn.cn","type":"notice"},{"name":"第十八届CISCN半决赛技术文件","url":"http://www.ciscn.cn/upload/file/20250304/1741074028785255.pdf","type":"rule"}]',
`timeline` = '[{"stage":"线上初赛","start":"每年12月","end":"每年12月","firstRatio":"前20%晋级","secondRatio":"—","thirdRatio":"—"},{"stage":"半决赛（分区赛）","start":"每年3月","end":"每年4月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"全国总决赛","start":"每年7月","end":"每年7月","firstRatio":"决赛前20%","secondRatio":"决赛前33%","thirdRatio":"其余"}]'
WHERE `name` = '全国大学生网络与信息安全竞赛';

-- 4. 中国高校计算机网络技术挑战赛 (C4-Net)
UPDATE `competition` SET
`background` = '中国高校计算机网络技术挑战赛(C4-Net)由中国计算机学会(CCF)主办，是教育部认可的A类学科竞赛。赛事紧密对接新一代网络技术产业需求，聚焦软件定义网络(SDN)、网络功能虚拟化(NFV)、P4可编程数据平面、网络人工智能(NetAI)等前沿方向，旨在推动网络技术创新与产业应用落地。',
`history` = '2017年：首届C4-Net举办，设立SDN方向\n2019年：增设网络AI和P4编程方向\n2021年：入选全国普通高校大学生竞赛排行榜\n2023年：赛题涵盖SDN、NFV、P4、NetAI、IBN五大方向\n2025年：第十届大赛，赛题难度和创新性持续提升',
`culture` = 'C4-Net以"创新网络、智联未来"为理念，倡导"学以致用、赛教融合"的竞赛文化。大赛采用企业真实场景命题，强调"不是纸上谈兵，而是真刀真枪"，让选手在解决实际问题中提升网络工程综合能力。',
`eligibility` = '学历要求：全日制在校本科生、研究生\n组队要求：3-5人组队\n专业技能：\n  - SDN方向：掌握OpenFlow协议、ONOS/OpenDaylight控制器、Mininet仿真\n  - P4方向：掌握P4-16语言、BMv2软件交换机\n  - 网络AI：掌握机器学习基础、网络数据分析\n  - 建议具备Python/Linux编程基础',
`tracks` = '[{"name":"SDN软件定义网络","type":"professional","desc":"基于OpenFlow协议的网络架构设计与实现，考察SDN控制器编程和网络应用开发","detailPage":""},{"name":"P4可编程数据平面","type":"professional","desc":"使用P4语言实现自定义数据包处理逻辑，部署到BMv2交换机","detailPage":""},{"name":"网络AI","type":"professional","desc":"利用机器学习方法解决网络流量预测、异常检测、智能路由等实际问题","detailPage":""},{"name":"NFV网络功能虚拟化","type":"professional","desc":"基于通用硬件平台实现网络功能，考察VNF编排与管理能力","detailPage":""}]',
`resources` = '[{"name":"C4-Net大赛官网","url":"https://net.c4best.cn/home/homepage","type":"notice"},{"name":"ONOS控制器官方文档","url":"https://wiki.onosproject.org","type":"rule"}]',
`timeline` = '[{"stage":"初赛（方案提交）","start":"每年5月","end":"每年6月","firstRatio":"前30%晋级","secondRatio":"—","thirdRatio":"—"},{"stage":"复赛（线上答辩验证）","start":"每年7月","end":"每年9月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"决赛（现场演示）","start":"每年9月","end":"每年10月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '中国高校计算机网络技术挑战赛';

-- 5. 蓝桥杯 · 网络安全赛道
UPDATE `competition` SET
`background` = '蓝桥杯全国软件和信息技术专业人才大赛由工业和信息化部人才交流中心主办，是国内参与人数最多的IT学科竞赛，每年参赛人数超过10万人。网络安全赛道是蓝桥杯近年来新增的热门赛道，聚焦网络协议深度分析、系统漏洞挖掘与利用、逆向工程、Shell脚本编程、Web安全基础等核心安全技能，为网络安全人才选拔提供重要平台。',
`history` = '2010年：首届蓝桥杯举办，仅设软件类赛项\n2015年：增设电子类赛项\n2019年：参赛人数突破6万，入选全国普通高校竞赛排行榜\n2022年：新增网络安全赛道\n2024年：赛项扩展至软件赛、电子赛、人工智能赛、数字科技创新赛、视觉艺术设计赛、专项赛六大类\n2025年：第16届蓝桥杯，赛项设置全面升级',
`culture` = '蓝桥杯以"立足行业、突出实践、广泛参与、促进就业"为宗旨，强调"以赛促学、以赛促教"。大赛题目贴近企业实际需求，注重考察选手解决实际问题的能力，获奖证书在IT行业求职中具有较高的认可度。',
`eligibility` = '学历要求：全日制在校大学生（本科、高职高专均可）\n组队要求：个人赛\n专业技能：\n  - 网络协议分析：TCP/IP协议栈、Wireshark抓包分析\n  - 逆向工程基础：x86/x64汇编、反汇编工具（IDA Pro/Ghidra）\n  - 系统安全：Linux/Windows系统安全基础\n  - Shell脚本编程：Bash/Python脚本编写\n  - Web安全基础：常见Web漏洞原理与利用',
`tracks` = '[{"name":"网络安全赛道","type":"professional","desc":"涵盖网络协议分析、系统安全、逆向工程、脚本编程","detailPage":""},{"name":"软件赛C/C++","type":"comprehensive","desc":"算法设计与C/C++编程实现，本专业可参与","detailPage":""},{"name":"软件赛Python","type":"comprehensive","desc":"Python编程与算法设计，本专业可参与","detailPage":""},{"name":"Web应用开发","type":"comprehensive","desc":"Web全栈开发，本专业可参与","detailPage":""},{"name":"人工智能赛","type":"other","desc":"AI应用开发","detailPage":""},{"name":"视觉艺术设计赛","type":"other","desc":"UI/UX设计、平面设计","detailPage":""}]',
`resources` = '[{"name":"蓝桥杯大赛官网","url":"https://dasai.lanqiao.cn","type":"notice"},{"name":"蓝桥杯练习系统","url":"https://lx.lanqiao.cn","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年10月","end":"次年3月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"省赛","start":"次年4月","end":"次年4月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"国赛","start":"次年5月","end":"次年6月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '蓝桥杯 · 网络安全赛道';

-- 6. 新华三杯全国大学生数字技术大赛
UPDATE `competition` SET
`background` = '新华三杯全国大学生数字技术大赛由紫光旗下新华三集团(H3C)主办，是国内数字技术领域规格高、覆盖面广的企业级赛事。大赛以H3C网络技术认证体系（H3CNE/H3CSE/H3CIE）为基础，涵盖园区网、数据中心、云计算、SDN等方向，每年吸引全国数百所高校的上万名学生参赛。',
`history` = '2010年：首届新华三杯举办\n2015年：增设云计算方向\n2018年：引入SDN/AD-Campus赛题\n2020年：参赛高校突破500所\n2023年：增设数据中心网络（VXLAN/EVPN）方向\n2025年：比赛内容持续升级，覆盖园区网、数据中心、广域网全场景',
`culture` = '新华三杯以"数字领航、智绘未来"为理念，强调"认证驱动、实战为王"。大赛内容与H3C认证体系紧密对接，获奖选手可获得H3C认证考试优惠或免考资格，优秀选手更可获得新华三及生态伙伴企业实习就业机会。',
`eligibility` = '学历要求：全日制在校大学生\n组队要求：个人赛\n专业技能：\n  - 掌握Comware V7平台设备配置命令\n  - 园区网：VLAN/STP/链路聚合/VRRP/OSPF\n  - 数据中心：VXLAN/EVPN基础\n  - 建议持有H3CNE或同等水平认证\n  - 熟练使用HCL(H3C Cloud Lab)模拟器',
`tracks` = '[{"name":"网络技术赛道","type":"professional","desc":"涵盖园区网三层架构、数据中心网络、广域网技术","detailPage":""},{"name":"云计算赛道","type":"professional","desc":"H3C CAS虚拟化平台、云桌面、云运维","detailPage":""},{"name":"SDN/AD-Campus赛道","type":"professional","desc":"软件定义网络、意图网络、园区网自动化部署","detailPage":""}]',
`resources` = '[{"name":"新华三杯大赛官网","url":"https://www.h3c.com/cn/pub/2026_Event/h3c_cup2026/","type":"notice"},{"name":"H3CNE认证学习指南","url":"https://www.h3c.com/cn/training","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年3月","end":"每年5月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"省赛（笔试）","start":"每年6月","end":"每年7月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"复赛（上机实验）","start":"每年8月","end":"每年9月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"全国总决赛","start":"每年10月","end":"每年10月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '新华三杯全国大学生数字技术大赛';

-- 7. 红帽挑战赛
UPDATE `competition` SET
`background` = '红帽挑战赛由全球领先的开源解决方案提供商Red Hat主办，是面向全球大学生的IT技术竞赛。大赛以红帽企业Linux(RHEL)为核心平台，考察选手在Linux系统管理、网络服务配置、Ansible自动化运维等方面的实操能力。红帽认证（RHCSA/RHCE/RHCA）是全球IT行业含金量最高的Linux认证之一。',
`history` = '2000年代初：Red Hat创办红帽学院项目\n2010年：红帽挑战赛首次在亚太区举办\n2015年：赛题加入Ansible自动化运维\n2019年：覆盖全球50+国家和地区\n2023年：赛题加入容器技术（Docker/Podman）\n2025年：持续扩展OpenShift和云原生方向',
`culture` = '红帽挑战赛以"开源精神、协作共赢"为核心文化，强调"开放、透明、共享"的价值观。比赛采用纯实操形式，选手在真实RHEL环境中完成系统管理和自动化任务，平台自动评分，确保公平公正。',
`eligibility` = '学历要求：全日制在校大学生\n组队要求：个人赛（线上实操）\n专业技能：\n  - Linux系统管理：文件系统、用户管理、SELinux、firewalld\n  - 网络服务配置：DNS/DHCP/HTTP/NFS/Samba\n  - Shell脚本自动化：Bash脚本编写\n  - Ansible自动化：Playbook编写、角色管理\n  - 建议持有RHCSA或同等水平认证',
`tracks` = '[{"name":"Linux系统管理赛道","type":"professional","desc":"RHEL系统管理、网络服务配置、安全策略实施","detailPage":""},{"name":"Ansible自动化赛道","type":"professional","desc":"Ansible Playbook编写、自动化运维、配置管理","detailPage":""}]',
`resources` = '[{"name":"红帽挑战赛官网","url":"https://www.redhat.com/en/events/red-hat-academy-challenge","type":"notice"},{"name":"RHCSA认证学习路径","url":"https://www.redhat.com/en/services/certification/rhcsa","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年6月","end":"每年9月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"线上竞赛","start":"每年10月","end":"每年11月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"全球总决赛","start":"每年12月","end":"每年12月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"}]'
WHERE `name` = '红帽挑战赛';

-- 8. 全国大学生电子设计竞赛 · 网络通信专题
UPDATE `competition` SET
`background` = '全国大学生电子设计竞赛由教育部和工业和信息化部共同主办，是国内最具权威性的大学生电子信息类学科竞赛。网络通信专题要求参赛队完成基于硬件的通信网络系统设计，包括数据链路层协议栈实现、无线网络组网、数字信号处理等综合性任务，是电子、通信、网络工程等专业学生展示综合工程能力的顶级平台。',
`history` = '1994年：首届全国大学生电子设计竞赛举办\n2000年：成为教育部和工信部共同主办的官方赛事\n2007年：增设网络通信专题方向\n2015年：引入物联网和无线通信方向\n2023年：赛题难度持续提升，覆盖WiFi/ZigBee/LoRa/BLE等多种无线协议\n2025年：奇数年大赛，四天三夜封闭竞赛',
`culture` = '电赛以"求真务实、追求卓越"为精神内核，四天三夜的封闭竞赛模式是对选手技术能力、团队协作和心理素质的极限考验。每一届比赛结束后，赛题都会成为电子工程教育的经典案例，全国高校师生争相讨论和学习。',
`eligibility` = '学历要求：全日制在校本科生\n组队要求：3人组队\n专业技能：\n  - 硬件设计：STM32/MSP430/FPGA开发\n  - 通信协议：WiFi/ZigBee/LoRa/BLE无线通信\n  - 信号处理：调制解调、编解码、滤波算法\n  - 嵌入式编程：C语言、RTOS\n  - 电路设计：PCB设计、焊接调试',
`tracks` = '[{"name":"网络通信专题","type":"professional","desc":"通信网络协议设计、无线网络系统搭建、信号处理","detailPage":""},{"name":"电源类","type":"other","desc":"开关电源、逆变器、DC-DC变换器","detailPage":""},{"name":"信号源类","type":"other","desc":"信号发生器、波形合成","detailPage":""},{"name":"放大器类","type":"other","desc":"高频放大器、功率放大器","detailPage":""},{"name":"仪器仪表类","type":"other","desc":"测量仪器、传感器","detailPage":""},{"name":"控制类","type":"comprehensive","desc":"电机控制、PID控制、智能小车","detailPage":""}]',
`resources` = '[{"name":"全国大学生电子设计竞赛官网","url":"https://www.nuedc.org.cn","type":"notice"},{"name":"历届赛题及优秀作品","url":"https://www.nuedc.org.cn","type":"rule"}]',
`timeline` = '[{"stage":"校内选拔","start":"每年5月","end":"每年6月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"全国竞赛（四天三夜）","start":"每年8月（奇数年）","end":"每年8月","firstRatio":"8%","secondRatio":"16%","thirdRatio":"24%"},{"stage":"全国复测","start":"每年11月","end":"每年11月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"}]'
WHERE `name` = '全国大学生电子设计竞赛 · 网络通信专题';

-- 9. 中国高校计算机大赛 · 网络技术挑战赛
UPDATE `competition` SET
`background` = '中国高校计算机大赛网络技术挑战赛(C4)由教育部高等学校计算机类专业教学指导委员会主办，紧密对接产业需求，以企业真实网络场景作为赛题。比赛要求参赛团队根据给定的业务需求，完成网络拓扑设计、设备选型、IP地址规划、路由协议配置、安全策略部署、网络服务搭建等一整套解决方案。',
`history` = '2016年：首届C4网络技术挑战赛举办\n2018年：赛题引入企业级网络真实场景\n2020年：入选全国普通高校大学生竞赛排行榜\n2022年：增设网络安全和云网融合方向\n2025年：赛题持续升级，覆盖企业组网全场景',
`culture` = 'C4大赛以"理论联系实际、方案对接产业"为核心理念，强调"不是考你会不会背命令，而是考你会不会做方案"。大赛评委来自华为、新华三、思科等企业一线工程师，评审标准与行业需求高度一致。',
`eligibility` = '学历要求：全日制在校本科生\n组队要求：2-4人组队\n专业技能：\n  - 网络架构设计：园区网三层架构、数据中心网络\n  - 路由协议：OSPF多区域、BGP基本属性\n  - 交换技术：VLAN规划、STP/MSTP、链路聚合\n  - 网络服务：DHCP/DNS/HTTP/NTP\n  - 安全策略：ACL、NAT、防火墙基础\n  - 建议具备Packet Tracer/eNSP/HCL实验经验',
`tracks` = '[{"name":"企业网络设计","type":"professional","desc":"根据企业业务需求设计完整网络方案，包括拓扑设计、设备选型、IP规划","detailPage":""},{"name":"网络技术前沿","type":"professional","desc":"SDN、NFV、网络AI等新技术方向","detailPage":""},{"name":"网络安全","type":"professional","desc":"网络安全策略设计、安全设备部署","detailPage":""}]',
`resources` = '[{"name":"C4大赛官网","url":"https://www.c4.org.cn","type":"notice"},{"name":"企业网络设计方案模板","url":"https://www.c4.org.cn","type":"rule"}]',
`timeline` = '[{"stage":"初赛（方案设计）","start":"每年5月","end":"每年6月","firstRatio":"前30%晋级","secondRatio":"—","thirdRatio":"—"},{"stage":"复赛（方案验证优化）","start":"每年7月","end":"每年9月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"总决赛（现场答辩）","start":"每年10月","end":"每年11月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '中国高校计算机大赛 · 网络技术挑战赛';

-- 10. 网络安全攻防大赛(XCTF)
UPDATE `competition` SET
`background` = 'XCTF国际联赛是国内首个以高校为主导的网络安全CTF（Capture The Flag）联赛平台，由清华大学蓝莲花战队发起，汇聚了国内数十所顶尖高校的安全战队。通过全年滚动举办的分站赛和年终总决赛，构建了国内规模最大、赛题质量最高、影响力最大的网络安全竞赛联赛体系。',
`history` = '2014年：清华大学蓝莲花战队发起首届XCTF\n2016年：分站赛扩展至全年10+场\n2018年：总决赛引入国际赛队\n2020年：联赛覆盖50+高校战队\n2023年：赛题难度和多样性持续提升\n2025年：XCTF联赛成为中国CTF竞赛的标杆平台',
`culture` = 'XCTF以"Capture The Flag, Capture The Future"为口号，倡导"技术无界、安全有我"的社区文化。联赛注重培养安全人才的实战能力，通过真实的攻防对抗场景，让选手在竞赛中快速成长。',
`eligibility` = '学历要求：无严格限制，以高校在校生为主\n组队要求：团队不限人数\n专业技能：\n  - Web安全：SQL注入、XSS、CSRF、SSRF、反序列化、SSTI\n  - PWN二进制：栈溢出、堆利用、ROP链、沙箱逃逸\n  - 逆向工程：反汇编、反编译、算法逆向、脱壳\n  - 密码学：RSA/AES/ECC攻击、格密码\n  - 杂项：流量分析、隐写术、取证、安全编码',
`tracks` = '[{"name":"CTF夺旗赛","type":"professional","desc":"覆盖Web/PWN/Reverse/Crypto/Misc五大方向，线上解题+线下攻防","detailPage":""},{"name":"AWD攻防赛","type":"professional","desc":"实时攻防对抗，每队维护自己的服务同时攻击对手","detailPage":""}]',
`resources` = '[{"name":"XCTF联赛官网","url":"https://www.xctf.org.cn","type":"notice"},{"name":"CTF训练平台推荐","url":"https://buuoj.cn","type":"rule"}]',
`timeline` = '[{"stage":"各分站赛","start":"每年3月","end":"每年12月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"年终总决赛","start":"每年12月","end":"每年12月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"}]'
WHERE `name` = '网络安全攻防大赛(XCTF)';

-- 11. 全国大学生网络技术知识竞赛
UPDATE `competition` SET
`background` = '全国大学生网络技术知识竞赛由中国计算机学会(CCF)主办，是国内首个面向网络技术初学者的全国性知识竞赛，非常适合大一、大二同学作为网络方向的入门竞赛。竞赛内容覆盖计算机网络核心基础知识，旨在激发学生对网络技术的学习兴趣，夯实网络工程专业基础。',
`history` = '2018年：首届网络技术知识竞赛举办\n2020年：参赛人数突破5000人\n2022年：竞赛内容更新，涵盖SDN/云计算等新技术\n2025年：持续优化赛题，覆盖更全面的网络知识体系',
`culture` = '该竞赛以"夯实基础、激发兴趣"为宗旨，强调"知识是技术的基石"。竞赛不追求高难度，而是注重考察学生对计算机网络基本原理的掌握程度，是网络工程专业学生检验学习成果的最佳平台。',
`eligibility` = '学历要求：全日制在校本科生、高职高专生\n组队要求：个人赛（线上考试）\n专业技能：\n  - OSI七层模型与TCP/IP协议栈体系\n  - IP地址分类与子网划分（CIDR/VLSM）\n  - VLAN原理与Trunk配置\n  - 静态路由与动态路由基础原理\n  - 传输层协议：TCP/UDP\n  - 应用层协议：HTTP/DNS/DHCP/FTP\n  - 建议完成《计算机网络》（谢希仁版）前8章学习',
`tracks` = '[{"name":"网络基础知识竞赛","type":"professional","desc":"覆盖计算机网络核心基础知识，线上统一考试","detailPage":""}]',
`resources` = '[{"name":"CCF官网","url":"https://www.ccf.org.cn","type":"notice"},{"name":"《计算机网络》谢希仁版","url":"https://www.ccf.org.cn","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年4月","end":"每年5月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"线上考试","start":"每年6月","end":"每年6月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"}]'
WHERE `name` = '全国大学生网络技术知识竞赛';

-- =====================================================
-- 二、综合性竞赛 (general, 匹配name)
-- =====================================================

-- 12. 中国大学生计算机设计大赛 (4C)
UPDATE `competition` SET
`background` = '中国大学生计算机设计大赛（简称"4C"）始筹于2007年，首届于2008年举办，由教育部高等学校计算机相关教指委独立发起主办，是我国最早面向高校本科生的计算机类赛事之一。大赛旨在激发大学生学习计算机知识和技能的兴趣，培养其创新创业能力和团队合作意识，提高其运用信息技术解决实际问题的综合实践能力。2025年已成功举办18届91场赛事，是国内规模最大的计算机类学科竞赛。',
`history` = '2007年：大赛开始筹备\n2008年：首届大赛举办，由文科计算机教指委独立主办\n2010年（第3届）：理工类计算机教指委参与主办\n2015年：入选全国普通高校大学生竞赛排行榜\n2018年：参赛作品突破万件\n2020年：增设人工智能、大数据、物联网等新类别\n2025年（第18届）：累计举办91场赛事，覆盖全国所有省份',
`culture` = '4C大赛以"创新、实用、协作"为核心价值，倡导"用计算机技术解决真实问题"的竞赛理念。大赛注重作品的创新性和实用性，鼓励学生将课堂所学应用到实际项目中，获奖作品往往具有较高的市场转化潜力。',
`eligibility` = '学历要求：全日制在校本科生\n组队要求：1-5人（可个人参赛）\n专业技能：\n  - 软件类：掌握主流开发技术栈（Vue/React + Spring Boot/Node.js）\n  - 设计类：精通PS、AI、AE等设计工具\n  - AI/大数据类：掌握Python数据分析、机器学习基础',
`tracks` = '[{"name":"软件应用与开发","type":"comprehensive","desc":"Web应用、移动应用、小程序开发，本专业可参与","detailPage":""},{"name":"物联网应用","type":"comprehensive","desc":"物联网系统设计与开发，网络工程专业优势方向","detailPage":""},{"name":"大数据应用","type":"comprehensive","desc":"数据采集、处理、分析与可视化","detailPage":""},{"name":"人工智能应用","type":"comprehensive","desc":"AI模型开发与部署","detailPage":""},{"name":"信息可视化设计","type":"comprehensive","desc":"数据可视化、交互设计","detailPage":""},{"name":"数字媒体设计","type":"other","desc":"平面设计、动画、微电影","detailPage":""},{"name":"计算机音乐创作","type":"other","desc":"音乐创作、编曲","detailPage":""}]',
`resources` = '[{"name":"4C大赛官网","url":"https://jsjds.blcu.edu.cn","type":"notice"},{"name":"2025年大赛竞赛规程","url":"https://jsjds.blcu.edu.cn","type":"rule"}]',
`timeline` = '[{"stage":"校赛","start":"每年1月","end":"每年3月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"省赛","start":"每年4月","end":"每年5月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"国赛（现场答辩）","start":"每年7月","end":"每年8月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '中国大学生计算机设计大赛';

-- 13. 全国大学生统计建模大赛
UPDATE `competition` SET
`background` = '全国大学生统计建模大赛由中国统计教育学会主办，是统计学领域最具影响力的全国性学术竞赛。大赛要求参赛者运用统计学方法、机器学习算法和计算机技术，对经济、社会、环境等领域的实际问题进行建模分析，最终提交一篇规范的建模论文。该赛事是统计学、数据科学、计算机等专业学生展示数据分析能力的绝佳平台。',
`history` = '2009年：首届统计建模大赛举办\n2013年：纳入中国统计教育学会官方赛事\n2017年：赛题从单一主题扩展为多主题自选\n2020年：参赛队伍突破5000支\n2023年：获奖论文有机会被推荐至统计学期刊\n2025年：持续提升学术影响力，评审标准更加严格',
`culture` = '统计建模大赛以"数据驱动决策、模型创造价值"为理念，强调统计学方法与计算机技术的深度融合。大赛注重学术规范性和论文质量，培养参赛者的科研能力和学术素养。',
`eligibility` = '学历要求：全日制在校本科生、研究生\n组队要求：3人组队\n专业技能：\n  - Python数据分析（NumPy/Pandas/Matplotlib）或R语言\n  - 机器学习基础（scikit-learn）\n  - 统计模型：回归分析、时间序列、聚类、分类\n  - 数据可视化：Tableau/Power BI\n  - 论文写作：学术论文规范格式',
`tracks` = '[{"name":"经济预测方向","type":"comprehensive","desc":"GDP/CPI/房价等经济指标预测建模","detailPage":""},{"name":"公共卫生方向","type":"comprehensive","desc":"疫情传播模型、健康数据分析","detailPage":""},{"name":"环境科学方向","type":"comprehensive","desc":"空气质量预测、环境数据分析","detailPage":""},{"name":"交通出行方向","type":"comprehensive","desc":"共享单车调度、交通流量预测","detailPage":""}]',
`resources` = '[{"name":"统计建模大赛官网","url":"https://tjjmds.ai-learning.net/","type":"notice"},{"name":"优秀论文汇编","url":"https://tjjmds.ai-learning.net/","type":"rule"}]',
`timeline` = '[{"stage":"赛题发布","start":"每年3月","end":"每年3月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"团队建模与论文提交","start":"每年3月","end":"每年4月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"评审公布","start":"每年5月","end":"每年6月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"}]'
WHERE `name` = '全国大学生统计建模大赛';

-- 14. 全国大学生数学建模竞赛(CUMCM)
UPDATE `competition` SET
`background` = '全国大学生数学建模竞赛(CUMCM)由教育部高等教育司和中国工业与应用数学学会共同主办，创办于1992年，每年一届，是首批列入"高校学科竞赛排行榜"的19项竞赛之一。2025年，来自全国及美国、英国、加拿大、芬兰、马来西亚等国家的1837所院校/校区、68311支队伍参赛，是国内规模最大、参与人数最多、含金量最高的基础性学科竞赛。',
`history` = '1992年：首届CUMCM举办，参赛队伍314支\n2000年：参赛队伍突破2000支\n2010年：参赛队伍突破20000支\n2020年：参赛队伍突破45000支\n2023年：参赛队伍突破60000支\n2025年：参赛队伍68311支，覆盖1837所院校，规模再创新高',
`culture` = 'CUMCM以"一次参赛，终身受益"为口号，倡导"三人行，必有我师"的团队协作精神。三天三夜的高强度竞赛不仅是技术的比拼，更是意志力、团队协作和临场决策能力的综合考验。每一届赛题都成为数学建模教育的经典案例，影响着千万学子的学术和职业发展。',
`eligibility` = '学历要求：全日制在校本科生、高职高专生\n组队要求：3人组队\n专业技能：\n  - 建模手：掌握微分方程、线性规划、图论、概率统计、评价模型\n  - 编程手：熟练MATLAB或Python（NumPy/SciPy/Matplotlib）\n  - 写作手：学术论文写作、LaTeX排版、Visio流程图\n  - 赛前需完成至少2-3次模拟真题训练',
`tracks` = '[{"name":"A题（工程物理类）","type":"comprehensive","desc":"通常涉及物理、工程领域的实际问题，对数学建模要求较高","detailPage":""},{"name":"B题（社会经管类）","type":"comprehensive","desc":"涉及经济、管理、社会领域的优化问题","detailPage":""},{"name":"C题（大数据类）","type":"comprehensive","desc":"涉及数据处理、统计分析、机器学习，本专业优势方向","detailPage":""}]',
`resources` = '[{"name":"CUMCM大赛官网","url":"https://www.mcm.edu.cn","type":"notice"},{"name":"2025竞赛第一次通知","url":"https://www.mcm.edu.cn","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年6月","end":"每年8月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"全国竞赛（72小时）","start":"每年9月第二个周四","end":"每年9月第三个周一","firstRatio":"1.5%","secondRatio":"6.5%","thirdRatio":"12%"},{"stage":"赛区评审","start":"每年10月","end":"每年11月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"全国评审","start":"每年12月","end":"每年12月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"}]'
WHERE `name` = '全国大学生数学建模竞赛(CUMCM)';

-- 15. 全国大学生软件创新大赛
UPDATE `competition` SET
`background` = '全国大学生软件创新大赛由教育部软件工程专业教学指导委员会主办，聚焦软件技术创新与应用，是国内软件工程领域最具代表性的学科竞赛。大赛涵盖移动应用、云计算、人工智能软件、智能终端、大数据应用、区块链应用等多个技术方向，要求参赛团队提交一个完整的软件产品，包括产品策划书、技术方案、可运行的系统原型和路演答辩。',
`history` = '2008年：首届软件创新大赛举办\n2012年：赛题扩展至移动应用方向\n2016年：引入AI和云计算方向\n2020年：参赛作品质量显著提升，获奖团队获投资关注\n2023年：增设区块链和Web3.0方向\n2025年：持续引领软件创新潮流',
`culture` = '软件创新大赛以"创新改变世界、软件定义未来"为理念，强调"从创意到产品"的完整闭环。大赛不仅考察技术实现，更注重产品的商业价值和社会影响力，是培养"技术+产品+商业"复合型人才的重要平台。',
`eligibility` = '学历要求：全日制在校本科生\n组队要求：3-5人组队\n专业技能：\n  - 前端：Vue3/React + TypeScript\n  - 后端：Spring Boot/Node.js/Go\n  - 数据库：MySQL + Redis\n  - 部署：Docker + Nginx\n  - 建议团队包含产品经理、前端、后端、UI设计四类角色',
`tracks` = '[{"name":"移动应用方向","type":"comprehensive","desc":"iOS/Android原生应用或跨平台应用开发","detailPage":""},{"name":"Web应用方向","type":"comprehensive","desc":"Web全栈开发，本专业可参与","detailPage":""},{"name":"AI应用方向","type":"comprehensive","desc":"AI+行业应用解决方案","detailPage":""},{"name":"云原生应用方向","type":"comprehensive","desc":"基于Docker/K8s的云原生架构","detailPage":""},{"name":"区块链应用方向","type":"other","desc":"区块链DApp开发","detailPage":""}]',
`resources` = '[{"name":"软件创新大赛官网","url":"https://www.swcontest.com.cn/index","type":"notice"},{"name":"参赛作品规范","url":"https://www.swcontest.com.cn/index","type":"rule"}]',
`timeline` = '[{"stage":"初赛（方案提交）","start":"每年4月","end":"每年5月","firstRatio":"前30%晋级","secondRatio":"—","thirdRatio":"—"},{"stage":"复赛（开发实现）","start":"每年6月","end":"每年8月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"决赛（路演答辩）","start":"每年9月","end":"每年10月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '全国大学生软件创新大赛';

-- 16. 蓝桥杯 · 软件类赛项
UPDATE `competition` SET
`background` = '蓝桥杯全国软件和信息技术专业人才大赛由工业和信息化部人才交流中心主办，是国内参与人数最多的IT学科竞赛，每年参赛人数超过10万人。软件类赛项涵盖C/C++、Java、Python等编程语言组别，考察算法设计与数据结构实现能力，是IT专业学生检验编程功底的热门赛事。',
`history` = '2010年：首届蓝桥杯举办，仅设软件类赛项\n2015年：增设电子类赛项\n2019年：参赛人数突破6万，入选全国普通高校竞赛排行榜\n2022年：新增网络安全赛道\n2024年：赛项扩展至六大类\n2025年：第16届蓝桥杯，软件类赛项持续优化',
`culture` = '蓝桥杯以"立足行业、突出实践、广泛参与、促进就业"为宗旨，强调"以赛促学"。软件类赛项是蓝桥杯的"王牌"赛项，省赛获奖证书在IT行业求职中具有较高的认可度，多家知名企业（华为、腾讯、百度等）在招聘时认可蓝桥杯获奖成绩。',
`eligibility` = '学历要求：全日制在校大学生（本科、高职高专均可）\n组队要求：个人赛\n专业技能：\n  - C/C++组：掌握STL、指针、内存管理\n  - Java组：掌握集合框架、多线程、JVM基础\n  - Python组：掌握标准库、常用算法实现\n  - 算法基础：排序、二分、双指针、滑动窗口\n  - 进阶算法：动态规划、贪心、DFS/BFS回溯、前缀和/差分\n  - 建议完成300+题目的练习量',
`tracks` = '[{"name":"C/C++程序设计","type":"comprehensive","desc":"算法设计与C/C++编程实现，本专业可参与","detailPage":""},{"name":"Java软件开发","type":"comprehensive","desc":"Java编程与算法设计，本专业可参与","detailPage":""},{"name":"Python程序设计","type":"comprehensive","desc":"Python编程与算法设计，本专业可参与","detailPage":""},{"name":"Web应用开发","type":"comprehensive","desc":"Web全栈开发，本专业可参与","detailPage":""},{"name":"软件测试","type":"comprehensive","desc":"软件测试方法与实践","detailPage":""}]',
`resources` = '[{"name":"蓝桥杯大赛官网","url":"https://dasai.lanqiao.cn","type":"notice"},{"name":"蓝桥杯练习系统","url":"https://lx.lanqiao.cn","type":"rule"}]',
`timeline` = '[{"stage":"报名期","start":"每年10月","end":"次年3月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"省赛","start":"次年4月","end":"次年4月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"国赛","start":"次年5月","end":"次年6月","firstRatio":"5%","secondRatio":"10%","thirdRatio":"15%"}]'
WHERE `name` = '蓝桥杯 · 软件类赛项';

-- 17. ACM-ICPC 国际大学生程序设计竞赛
UPDATE `competition` SET
`background` = 'ACM-ICPC（国际大学生程序设计竞赛，现称ICPC）由国际计算机协会(ACM)主办，是全球历史最悠久、影响力最大、含金量最高的大学生程序设计竞赛，被称为计算机界的"奥林匹克"。1970年首届比赛在美国德克萨斯A&M大学举办，1977年举办首次全球总决赛，至今已连续举办近50年。比赛采用3人一队共用一台电脑，在5小时内完成8-12道算法题的形式。',
`history` = '1970年：首届比赛在美国德克萨斯A&M大学举办\n1977年：首次全球总决赛在ACM计算机科学会议期间举办\n1990年代：赛事扩展至欧洲和亚洲\n2000年代：中国高校开始大规模参与，清华、北大、上交等校队屡获佳绩\n2010年代：全球参赛队伍突破5000支\n2020年：赛事更名为ICPC，由ICPC基金会运营\n2025年：持续吸引全球顶尖程序设计人才',
`culture` = 'ICPC以"Think Together, Code Together, Win Together"为团队精神，强调"算法为魂、编程为器、协作为本"。ICPC获奖选手是各大科技公司（Google、Facebook、Microsoft、华为等）竞相争夺的人才，世界总决赛奖牌获得者往往能获得顶级offer。',
`eligibility` = '学历要求：全日制在校大学生（本科生或研究生）\n组队要求：3人组队\n专业技能：\n  - 数据结构：数组、链表、栈、队列、树、图、哈希表、线段树、树状数组\n  - 基础算法：排序、二分查找、双指针、DFS/BFS\n  - 进阶算法：动态规划、贪心、网络流、计算几何\n  - 高阶算法：数论、字符串（KMP）、平衡树\n  - 建议在Codeforces达到蓝名（1600+）水平',
`tracks` = '[{"name":"ICPC区域赛","type":"comprehensive","desc":"亚洲区域赛，前若干名晋级世界总决赛","detailPage":""},{"name":"CCPC中国大学生程序设计竞赛","type":"comprehensive","desc":"中国赛区最高水平赛事，本专业有机会参与","detailPage":""}]',
`resources` = '[{"name":"ICPC全球官网","url":"https://icpc.global","type":"notice"},{"name":"Codeforces训练平台","url":"https://codeforces.com","type":"rule"}]',
`timeline` = '[{"stage":"校选赛（加入校队）","start":"每年9月","end":"每年10月","firstRatio":"—","secondRatio":"—","thirdRatio":"—"},{"stage":"区域网络预选赛","start":"每年9月","end":"每年10月","firstRatio":"前30%晋级","secondRatio":"—","thirdRatio":"—"},{"stage":"亚洲区域赛","start":"每年11月","end":"每年12月","firstRatio":"10%","secondRatio":"20%","thirdRatio":"30%"},{"stage":"世界总决赛","start":"次年4月","end":"次年6月","firstRatio":"4枚金牌","secondRatio":"4枚银牌","thirdRatio":"4枚铜牌"}]'
WHERE `name` = 'ACM-ICPC 国际大学生程序设计竞赛';

-- =====================================================
-- 验证更新结果
-- =====================================================
SELECT id, name, 
       CASE WHEN background IS NOT NULL THEN '✓' ELSE '✗' END AS bg,
       CASE WHEN `history` IS NOT NULL THEN '✓' ELSE '✗' END AS hist,
       CASE WHEN culture IS NOT NULL THEN '✓' ELSE '✗' END AS cult,
       CASE WHEN eligibility IS NOT NULL THEN '✓' ELSE '✗' END AS eli,
       CASE WHEN tracks IS NOT NULL THEN '✓' ELSE '✗' END AS trk,
       CASE WHEN resources IS NOT NULL THEN '✓' ELSE '✗' END AS res,
       CASE WHEN timeline IS NOT NULL THEN '✓' ELSE '✗' END AS tl
FROM `competition`
ORDER BY `type`, id;