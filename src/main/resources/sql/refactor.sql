-- =====================================================
-- 管理员端重构 - 数据库增量脚本
-- 在 Navicat 中打开所属数据库，逐条执行即可
-- =====================================================

-- 1. 系统配置表
CREATE TABLE `system_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `config_key` varchar(100) NOT NULL COMMENT '配置键',
  `config_value` varchar(500) NOT NULL COMMENT '配置值',
  `description` varchar(255) DEFAULT NULL COMMENT '说明',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_config_key` (`config_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2. 操作日志表
CREATE TABLE `operation_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin_id` int DEFAULT NULL COMMENT '管理员ID',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `module` varchar(50) DEFAULT NULL COMMENT '操作模块',
  `action` varchar(50) DEFAULT NULL COMMENT '操作类型',
  `target` varchar(200) DEFAULT NULL COMMENT '操作对象',
  `content` text COMMENT '操作详情',
  `ip` varchar(50) DEFAULT NULL COMMENT '操作IP',
  `time` varchar(30) DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. 组队表
CREATE TABLE `team` (
  `id` int NOT NULL AUTO_INCREMENT,
  `team_name` varchar(100) NOT NULL COMMENT '队伍名称',
  `description` text COMMENT '队伍描述',
  `max_members` int DEFAULT 5 COMMENT '最大人数',
  `leader_id` int NOT NULL COMMENT '队长ID',
  `activity_id` int DEFAULT NULL COMMENT '关联竞赛ID',
  `status` varchar(20) DEFAULT 'ACTIVE' COMMENT 'ACTIVE活跃/DISBANDED解散',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4. 队员表
CREATE TABLE `team_member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `team_id` int NOT NULL COMMENT '队伍ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `role` varchar(20) DEFAULT 'MEMBER' COMMENT 'LEADER队长/MEMBER队员',
  `join_time` varchar(30) DEFAULT NULL COMMENT '加入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. 认证考试表
CREATE TABLE `certification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL COMMENT '考试名称',
  `description` text COMMENT '考试描述',
  `exam_time` varchar(30) DEFAULT NULL COMMENT '考试时间',
  `location` varchar(200) DEFAULT NULL COMMENT '考试地点',
  `max_participants` int DEFAULT NULL COMMENT '最大人数',
  `img` varchar(500) DEFAULT NULL COMMENT '封面图',
  `status` varchar(20) DEFAULT 'OPEN' COMMENT 'OPEN开放/CLOSED关闭/FINISHED已结束',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 6. 认证考试报名表
CREATE TABLE `certification_apply` (
  `id` int NOT NULL AUTO_INCREMENT,
  `certification_id` int NOT NULL COMMENT '考试ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `time` varchar(30) DEFAULT NULL COMMENT '报名时间',
  `status` varchar(20) DEFAULT 'PENDING' COMMENT 'PENDING待审/APPROVED通过/REJECTED驳回',
  `score` varchar(20) DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 7. user 表增加 status 字段
ALTER TABLE `user` ADD COLUMN `status` varchar(20) DEFAULT 'ACTIVE' COMMENT 'ACTIVE正常/BANNED封禁';

-- =====================================================
-- 网络工程竞赛表
-- =====================================================
CREATE TABLE IF NOT EXISTS `competition` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '竞赛名称',
  `description` varchar(500) DEFAULT NULL COMMENT '简要描述',
  `icon_img` varchar(500) DEFAULT NULL COMMENT '图标路径',
  `bg_image` text COMMENT '背景图CSS',
  `watermark` varchar(50) DEFAULT NULL COMMENT '水印文字',
  `level` varchar(20) DEFAULT NULL COMMENT '级别:国家级/国际级',
  `level_type` varchar(20) DEFAULT NULL COMMENT '级别类型:national/international',
  `tag` varchar(20) DEFAULT NULL COMMENT '标签:企业赛/学科赛',
  `time` varchar(100) DEFAULT NULL COMMENT '比赛时间',
  `organizer` varchar(100) DEFAULT NULL COMMENT '主办单位',
  `techs` varchar(500) DEFAULT NULL COMMENT '技术方向(逗号分隔)',
  `full_desc` text COMMENT '竞赛简介',
  `mode` varchar(100) DEFAULT NULL COMMENT '参赛形式',
  `website` varchar(200) DEFAULT NULL COMMENT '官方网址',
  `advice` text COMMENT '参赛建议',
  `suitable` text COMMENT '如何参赛',
  `grades` varchar(100) DEFAULT NULL COMMENT '适合年级(逗号分隔)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='网络工程竞赛';

-- 插入11个网络工程竞赛初始数据
INSERT INTO `competition` (`id`, `name`, `description`, `icon_img`, `bg_image`, `watermark`, `level`, `level_type`, `tag`, `time`, `organizer`, `techs`, `full_desc`, `mode`, `website`, `advice`, `suitable`, `grades`) VALUES
(1, '华为ICT大赛 · 网络赛道', '华为面向全球大学生举办的ICT领域顶级赛事，网络赛道涵盖路由交换、网络安全、WLAN等核心技术，考察学生的网络规划设计及故障排除能力。', '@/assets/imgs/comp-huawai.png', 'linear-gradient(135deg, rgba(207, 10, 44, 0.9) 0%, rgba(180, 50, 50, 0.85) 100%)', 'HUAWEI', '国家级', 'national', '企业赛', '每年9月-次年5月', '华为技术有限公司', '路由交换,网络安全,WLAN,广域网', '华为ICT大赛是华为公司面向全球大学生打造的年度ICT领域顶级赛事，入选中国高等教育学会"全国普通高校大学生竞赛排行榜"，是中国最具影响力的IT类学科竞赛之一。网络赛道主要考察学生在数据通信、网络安全、无线局域网、广域网接入等方面的理论知识和实操能力，包括网络拓扑设计、设备配置、故障排除等环节。比赛分为省赛、国赛、全球总决赛三个阶段，省赛采用理论笔试+上机实验形式，国赛增设现场答辩环节，全球总决赛则与各国顶尖选手同台竞技。优秀选手有机会获得华为HCIA/HCIP认证免考资格、华为及生态伙伴企业实习就业offer，往届获奖者多进入华为、中国移动、新华三等行业头部企业。', '个人赛（省赛）+ 团队赛（国赛，3人组队）', 'www.huawei.com/minisite/ict-competition-2024-2025-global/cn/index.html', '【前期准备】建议提前3-6个月开始系统备考，优先考取华为HCIA-Datacom认证打基础，有条件的可冲刺HCIP。核心学习资源包括华为官方教材《HCIA-Datacom学习指南》和华为ICT学院在线课程。【技术重点】路由交换方向重点掌握OSPF多区域配置、BGP基本属性、VLAN/STP/RSTP/MSTP、链路聚合Eth-Trunk、VRRP高可用等；网络安全方向需熟悉防火墙安全策略、ACL包过滤、NAT地址转换、IPSec VPN隧道技术、AAA认证等。【实验工具】强烈推荐使用华为eNSP模拟器进行拓扑搭建和协议实验，辅以真机操作加深理解。可参加学校华为ICT学院的赛前集训班，跟着老师系统走一遍比赛大纲。', '【报名方式】通过华为ICT学院官网（e.huawei.com/cn/talent/ict-academic）或学校华为ICT学院统一报名，通常由学校指导老师组织。【参赛流程】省赛每年10-11月举行（理论+上机），国赛次年3-5月举行（团队赛+答辩），全球总决赛5-6月举行。【报名时间】建议每年9月开学后密切关注学校华为ICT学院通知，提前组队（3人）并联系指导老师。', '大二,大三,大四'),
(2, '思科网络技术大赛', '思科公司主办的全球性网络技术竞赛，通过Packet Tracer模拟真实网络环境，考察学生在网络设计、配置、排错等方面的综合实战能力。', '@/assets/imgs/comp-sike.png', 'linear-gradient(135deg, rgba(0, 102, 204, 0.9) 0%, rgba(0, 130, 230, 0.85) 100%)', 'CISCO', '国际级', 'international', '企业赛', '每年3月-8月', '思科系统公司', 'CCNA/CCNP,网络设计,排错,网络安全', '思科网络技术大赛（思科网院杯）由思科系统公司主办，是全球网络技术教育领域最具影响力的竞赛之一，在全球超过180个国家和地区开展。比赛依托思科Packet Tracer网络仿真平台，参赛者需要在模拟的企业网络中完成网络拓扑设计、设备配置、路由协议调试、网络安全策略部署、网络故障排查等一系列任务。比赛涵盖CCNA和CCNP认证的核心知识点，每年吸引全球数万名网络技术专业学生参赛。', '个人赛（线上）', 'www.netacad.com/zh/', '【核心工具】必须熟练掌握思科Packet Tracer模拟器，建议同时使用GNS3进行更复杂的拓扑实验。Packet Tracer适合入门和基础实验，GNS3适合搭建真实IOS环境的复杂网络。【技术重点】路由协议掌握EIGRP（思科私有）、OSPF多区域、BGP基础；交换技术重点掌握VLAN/Trunk/VTP、STP/RSTP、EtherChannel链路聚合。', '【报名入口】通过思科网院(Cisco Networking Academy)平台（www.netacad.com）在线报名，需要先注册思科网院账号并关联所在学校。【参赛形式】个人线上参赛，在规定时间内完成Packet Tracer平台上的网络搭建和配置任务。', '大二,大三,大四'),
(3, '全国大学生网络与信息安全竞赛', '教育部主办的全国性学科竞赛，分为网络安全理论赛和CTF实战赛，全面考察学生的网络攻防、密码学、Web安全等技能。', '@/assets/imgs/comp-xinxianquan.png', 'linear-gradient(135deg, rgba(26, 35, 126, 0.88) 0%, rgba(40, 53, 147, 0.82) 100%)', 'CISCN', '国家级', 'national', '学科赛', '每年4月-11月', '教育部高等学校网络空间安全专业教指委', 'CTF夺旗,Web安全,密码学,渗透测试', '全国大学生信息安全竞赛(CISCN)由教育部高等学校网络空间安全专业教学指导委员会主办，是国内规模最大、权威性最高的网络安全类学科竞赛，入选国家级A类竞赛榜单，获奖含金量极高，在保研加分和求职中都极具分量。比赛分为线上初赛和线下决赛两个阶段，初赛以CTF夺旗赛形式进行，考察选手在Web安全、二进制安全(PWN)、逆向工程(Reverse)、密码学(Crypto)和杂项(Misc)等多维度的安全攻防能力。', '团队赛（4人组队，初赛线上+决赛线下）', 'www.ciscn.cn', '【入门路径】建议从Web安全和密码学入手，学习OWASP Top 10漏洞原理（SQL注入、XSS、CSRF、文件上传等），逐步拓展到逆向工程和PWN方向。【训练平台】CTF刷题推荐BUUCTF、NSSCTF、CTFHub等国内平台，国际平台可刷CTFtime、picoCTF。每周至少完成5-10道题目，建立自己的解题笔记和工具脚本库。', '【报名方式】通过大赛官网(www.ciscn.cn)在线报名，必须以学校为单位4人组队参赛，每校可报多支队伍。【参赛流程】线上初赛（4-5月）→ 分区赛（6-7月）→ 线下总决赛（8-11月）。初赛为CTF解题模式，决赛为AWD攻防对抗模式。', '大二,大三,大四'),
(4, '中国高校计算机网络技术挑战赛', 'CCF主办的全国性网络技术竞赛，聚焦SDN软件定义网络、网络测量、网络AI等前沿方向，推动网络技术创新与应用。', '@/assets/imgs/comp-wangluotiaozhan.png', 'linear-gradient(135deg, rgba(0, 77, 64, 0.9) 0%, rgba(0, 105, 92, 0.85) 100%)', 'CCF', '国家级', 'national', '学科赛', '每年5月-10月', '中国计算机学会(CCF)', 'SDN,网络测量,网络AI,P4编程', '中国高校计算机网络技术挑战赛(C4-Net)由中国计算机学会(CCF)主办，是教育部认可的A类学科竞赛。赛事紧密对接新一代网络技术产业需求，聚焦软件定义网络(SDN)、网络功能虚拟化(NFV)、P4可编程数据平面、网络人工智能(NetAI)、意图网络(IBN)等前沿方向。比赛采用真实的企业级场景命题，要求选手在限定时间内完成网络架构方案设计、系统实现和现场演示答辩。', '团队赛（3-5人组队）', 'net.c4best.cn/home/homepage', '【SDN核心】系统学习SDN三层架构（应用层/控制层/基础设施层），掌握OpenFlow 1.3协议规范和南向接口通信机制。熟练使用Mininet搭建虚拟网络拓扑，掌握ONOS或OpenDaylight控制器的安装配置和北向API调用。【P4编程】学习P4语言（P4-16版本）基本语法，掌握BMv2软件交换机的编译部署流程。', '【报名流程】通过大赛官网(c4net.ccf.org.cn)在线报名，3-5人组队参赛，建议团队包含网络架构设计、SDN/P4编程实现和文档演示三类角色。【赛程安排】初赛（5-6月提交方案）→ 复赛（7-8月线上答辩验证）→ 决赛（9-10月现场演示）。', '大三,大四'),
(5, '蓝桥杯 · 网络安全赛道', '蓝桥杯全国软件和信息技术专业人才大赛的网络与信息安全赛道，涵盖网络协议分析、系统安全、逆向工程等内容。', '@/assets/imgs/comp-lanqiao.png', 'linear-gradient(135deg, rgba(74, 20, 140, 0.88) 0%, rgba(123, 31, 162, 0.82) 100%)', 'LANQIAO', '国家级', 'national', '学科赛', '每年10月-次年4月', '工业和信息化部人才交流中心', '协议分析,逆向工程,系统安全,脚本编程', '蓝桥杯全国软件和信息技术专业人才大赛由工业和信息化部人才交流中心主办，入选全国普通高校大学生竞赛排行榜，是国内参与人数最多的IT学科竞赛，每年参赛人数超过10万人。网络安全赛道是蓝桥杯近年来新增的热门赛道，聚焦网络协议深度分析、系统漏洞挖掘与利用、逆向工程、Shell脚本编程、Web安全基础等核心安全技能。', '个人赛', 'dasai.lanqiao.cn/', '【官方平台】强烈推荐使用蓝桥杯官方练习系统（dasai.lanqiao.cn）进行专项刷题训练，系统内置历年真题和模拟题，支持在线判分和解析。【技术重点】网络协议分析：掌握TCP/IP协议栈各层协议头部结构，熟练使用Wireshark进行流量分析。', '【报名方式】通过蓝桥杯官网（dasai.lanqiao.cn）个人在线报名，或通过学校统一报名。建议选择学校统一报名方式，可享受优惠报名费（约300元/人）。【参赛流程】省赛（每年4月）→ 国赛（每年5-6月）。', '大二,大三,大四'),
(6, '新华三杯全国大学生数字技术大赛', '新华三集团主办的全国性数字技术赛事，网络技术赛道聚焦园区网、数据中心网络、广域网等场景的规划与部署。', '@/assets/imgs/comp-xinhuasan.png', 'linear-gradient(135deg, rgba(230, 81, 0, 0.9) 0%, rgba(245, 124, 0, 0.85) 100%)', 'H3C', '国家级', 'national', '企业赛', '每年3月-10月', '新华三集团(H3C)', '园区网,数据中心,云计算,SDN', '新华三杯全国大学生数字技术大赛由紫光旗下新华三集团(H3C)主办，是国内数字技术领域规格高、覆盖面广的企业级赛事，每年吸引全国数百所高校的上万名学生参赛。比赛以H3C网络技术认证体系（H3CNE/H3CSE/H3CIE）为基础，涵盖园区网三层架构设计、数据中心网络方案规划（VXLAN/EVPN）、软件定义网络(SDN/AD-Campus)部署、云计算基础架构（H3C CAS）等方向。', '个人赛', 'www.h3c.com/cn/pub/2026_Event/h3c_cup2026/', '【认证体系】建议系统学习H3C NE/SE认证课程，重点掌握Comware V7平台设备配置命令、IRF智能弹性架构堆叠技术、VXLAN数据中心Overlay组网方案、SDN/AD-Campus控制器部署等。【模拟工具】使用HCL(H3C Cloud Lab)模拟器进行实验练习。', '【报名入口】通过新华三杯官网（www.h3c.com/cn/training）在线报名，个人参赛。【赛程安排】报名（3-5月）→ 省赛笔试（6-7月）→ 复赛上机实验（8-9月）→ 全国总决赛（10月）。', '大二,大三,大四'),
(7, '红帽挑战赛', 'Red Hat主办的全球性开源技术竞赛，考察学生在Linux系统管理、网络服务部署、自动化运维等方面的实践能力。', '@/assets/imgs/comp-hongmao.png', 'linear-gradient(135deg, rgba(183, 28, 28, 0.9) 0%, rgba(211, 47, 47, 0.85) 100%)', 'RED HAT', '国际级', 'international', '企业赛', '每年6月-12月', '红帽公司(Red Hat)', 'Linux,网络服务,自动化,Ansible', '红帽挑战赛由全球领先的开源解决方案提供商Red Hat主办，是面向全球大学生的IT技术竞赛，在全球多个赛区同步举办。比赛以红帽企业Linux(RHEL)为核心平台，考察选手在Linux系统管理、网络服务配置（DNS/DHCP/HTTP/NFS/Samba）、Shell脚本自动化、Ansible自动化运维、容器基础（Docker/Podman）以及OpenShift基础等方面的实操能力。', '个人赛（线上实操）', 'www.redhat.com/en/events/red-hat-academy-challenge', '【认证路径】推荐按照RHCSA → RHCE路线系统学习，RHCSA聚焦基础系统管理，RHCE聚焦Ansible自动化。【技术重点】Linux基础：文件系统层级结构、用户与组管理、SELinux基本配置、firewalld防火墙；网络服务：DNS、DHCP、HTTP、NFS/Samba文件共享。', '【报名入口】通过Red Hat Academy官网（www.redhat.com）在线报名，个人线上参赛。需要先注册Red Hat Academy账号。【参赛形式】比赛在线上平台进行，选手在规定时间内完成一系列实操任务，平台自动评分排名。', '大二,大三,大四'),
(8, '全国大学生电子设计竞赛 · 网络通信专题', '教育部和工信部共同主办的全国性大学生学科竞赛，网络通信专题要求学生完成通信网络协议设计、无线网络系统搭建、信号处理等综合任务。', '@/assets/imgs/comp-dianzisheji.png', 'linear-gradient(135deg, rgba(0, 121, 107, 0.9) 0%, rgba(0, 150, 136, 0.85) 100%)', 'CUDSE', '国家级', 'national', '学科赛', '每年5月-9月', '教育部/工业和信息化部', '通信协议,无线网络,信号处理,FPGA', '全国大学生电子设计竞赛由教育部和工业和信息化部共同主办，是国内最具权威性的大学生电子信息类学科竞赛，每两年举办一次（奇数年）。网络通信专题要求参赛队完成基于硬件的通信网络系统设计，包括数据链路层协议栈实现、无线网络组网（WiFi/ZigBee/LoRa/BLE）、数字信号处理（调制解调/编解码）、网络性能优化等综合性任务。', '团队赛（3人组队，四天三夜封闭竞赛）', 'www.nuedc.org.cn', '【团队配置】经典3人组合：1人负责硬件设计、1人负责嵌入式软件、1人负责系统联调和报告撰写。三人需高度默契，赛前至少完成3-5次模拟封闭训练。【技术准备】硬件平台：推荐STM32/MSP430/FPGA + 无线通信模块。', '【报名方式】由学校统一组织报名，不接受个人报名。每校有名额限制（通常10-20队），需通过校内选拔赛确定参赛队伍。【赛程安排】发布赛题（8月）→ 四天三夜封闭竞赛 → 提交作品和报告 → 赛区评审（9-10月）→ 全国复测（11月）。', '大三,大四'),
(9, '中国高校计算机大赛 · 网络技术挑战赛', '教育部高等学校计算机类专业教指委主办的全国性赛事，以企业真实网络场景为赛题，考察团队网络架构设计、部署优化及故障排查能力。', '@/assets/imgs/comp-gaoxiaojisuanji-wangluo.png', 'linear-gradient(135deg, rgba(21, 101, 192, 0.9) 0%, rgba(41, 121, 255, 0.85) 100%)', 'C4', '国家级', 'national', '学科赛', '每年5月-11月', '教育部高等学校计算机类专业教指委', '网络架构,企业组网,性能优化,故障排查', '中国高校计算机大赛网络技术挑战赛(C4)由教育部高等学校计算机类专业教学指导委员会主办，紧密对接产业需求，以企业真实网络场景作为赛题。比赛分为初赛、复赛和决赛三个阶段，要求参赛团队根据给定的业务需求和约束条件，完成网络拓扑设计、设备选型、IP地址规划、路由协议配置、安全策略部署、网络服务搭建等一整套解决方案。', '团队赛（2-4人组队）', 'www.c4.org.cn', '【方案设计】企业网络设计核心原则：高可靠性、安全性、可扩展性、可管理性。【技术要点】路由协议选型：OSPF适用于园区网内部、BGP适用于多出口/多站点互联；VLAN规划：按部门/功能划分、IP子网合理分配。', '【报名流程】通过大赛官网(www.c4.org.cn)在线报名，2-4人组队参赛。【赛程安排】初赛方案设计（5-6月）→ 复赛方案验证优化（7-9月）→ 总决赛现场答辩（10-11月）。', '大三,大四'),
(10, '网络安全攻防大赛(XCTF)', '国内规模最大的CTF联赛平台，汇聚国内外顶尖安全战队，赛题覆盖Web安全、PWN二进制、逆向工程、密码学、杂项等多个安全领域。', '@/assets/imgs/comp-xctf.png', 'linear-gradient(135deg, rgba(48, 63, 159, 0.9) 0%, rgba(63, 81, 181, 0.85) 100%)', 'XCTF', '国际级', 'international', '企业赛', '每年3月-12月（分站赛全年开放）', 'XCTF社区/蓝莲花战队', 'Web安全,PWN,逆向工程,密码学', 'XCTF国际联赛是国内首个以高校为主导的网络安全CTF（Capture The Flag）联赛平台，由清华大学蓝莲花战队发起，汇聚了国内数十所顶尖高校的安全战队，是目前国内规模最大、赛题质量最高、影响力最大的网络安全竞赛联赛体系。', '团队赛（不限人数，线上分站赛+线下总决赛）', 'www.xctf.org', '【方向选择】建议选择1-2个方向深入突破：Web安全入手门槛低但天花板高；PWN方向难度大但含金量最高；逆向工程需要耐心和细心；密码学更偏向数学基础。【训练路径】入门阶段：在BUUCTF/NSSCTF平台刷Web和Misc入门题；进阶阶段：开始接触PWN和Reverse。', '【报名方式】通过XCTF官网(www.xctf.org)或各分站赛独立渠道在线报名，团队不限人数。各分站赛独立报名，全年滚动开放。【参赛建议】从低难度分站赛开始积累经验，逐步挑战高难度赛事。', '大二,大三,大四'),
(11, '全国大学生网络技术知识竞赛', '面向全国高校本专科生的网络技术基础知识竞赛，考察计算机网络的协议体系、IP地址与子网划分、常用网络设备原理、企业组网基础架构等核心知识点。', '@/assets/imgs/comp-wangluozhishi.png', 'linear-gradient(135deg, rgba(0, 140, 220, 0.9) 0%, rgba(0, 180, 160, 0.85) 100%)', 'NETKN', '国家级', 'national', '知识赛', '每年4月-6月', '中国计算机学会(CCF)', 'TCP/IP协议,子网划分,路由交换基础,Wireshark', '全国大学生网络技术知识竞赛由中国计算机学会(CCF)主办，是国内首个面向网络技术初学者的全国性知识竞赛，非常适合大一、大二同学作为网络方向的入门竞赛。竞赛内容覆盖计算机网络核心基础知识，包括OSI七层模型与TCP/IP协议栈体系、IP地址分类与子网划分（CIDR/VLSM）、VLAN原理与Trunk配置、静态路由与动态路由基础原理等。', '个人赛（线上考试）', 'www.ccf.org.cn', '【核心教材】推荐系统学习《计算机网络》（谢希仁版，第8版）前8章内容，重点掌握各章节的课后习题和思考题。【学习路径】第一阶段（基础概念）：理解网络分层思想；第二阶段（IP与子网）：掌握IP地址分类、子网掩码计算、CIDR地址聚合；第三阶段（协议分析）：使用Wireshark进行实际抓包练习。', '【报名方式】通过CCF官网(www.ccf.org.cn)在线报名，个人参赛。需先注册CCF学生会员（会费约50元/年），会员可享受报名优惠。【参赛流程】线上统一考试，在规定时间内（约2小时）在线完成答题，系统自动判分。', '大一,大二,大三,大四');