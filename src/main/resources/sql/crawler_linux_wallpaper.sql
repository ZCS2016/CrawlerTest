CREATE DATABASE  IF NOT EXISTS `crawler` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `crawler`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: crawler
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `linux_wallpaper`
--

DROP TABLE IF EXISTS `linux_wallpaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `linux_wallpaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `src` varchar(256) DEFAULT NULL COMMENT '链接',
  `hash` varchar(64) NOT NULL COMMENT 'hash',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hash_UNIQUE` (`hash`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linux_wallpaper`
--

LOCK TABLES `linux_wallpaper` WRITE;
/*!40000 ALTER TABLE `linux_wallpaper` DISABLE KEYS */;
INSERT INTO `linux_wallpaper` VALUES (1,'Gnome HIDPI 壁纸','https://www.linuxidc.com/upload/2018_05/18050119472444t.jpg','1cd34540c50526ad07b28a967cf437f085add229bb699a6aeabfae7c9a0b894b'),(2,'Arch Linux 桌面壁纸','https://www.linuxidc.com/upload/2018_04/180401134235571t.jpg','a53dff2086468dcd229d89e083107b9c63815328acdf8877b39fe2697bbf68fd'),(3,'Ubuntu 18.04 LTS 默','https://www.linuxidc.com/upload/2018_03/18032409202878t.jpg','e8243980fd8cc4b66e35cbb38c6d1001efae747f0a61e903e7fc31c8ceff82d7'),(4,'Linux LOGO桌面壁纸','https://www.linuxidc.com/upload/2018_03/180301210425741t.jpg','2cb42a52766fd553392c4fa6c4a91e02c4d7e6e07ea28067064f22c7ba90345e'),(5,'Ubuntu LOGO桌面壁纸','https://www.linuxidc.com/upload/2018_02/18020120045695t.jpg','eedde3c036d938c46a6e0e4f51da7c86e79f47472aa248c690967da912e05465'),(6,'暗灰色 Ubuntu LOGO壁','https://www.linuxidc.com/upload/2018_01/18012814329060t.jpg','4c814054d13ea70ccaf12a1f2fb9729d6845afb126ee31e442ecc713677c9399'),(7,'Ubuntu 壁纸亮黑主题','https://www.linuxidc.com/upload/2018_01/18012307037803t.jpg','eb1f486aa0909f271750dec1d6e76bc98cc7b82df3306b8e4f5191a220f89b44'),(8,'Linux壁纸 1920 x','https://www.linuxidc.com/upload/2018_01/180101200789151t.jpg','b3da0b6a6505c77c9efbf4e0e13dd9779eec0e06daa76641fafc33f4672e1751'),(9,'Puppy Linux 桌面壁纸','https://www.linuxidc.com/upload/2017_12/17120120465217t.jpg','72ca7bfe58fe7c0c2fca519e022f7be946f44695fd140edb7c71af56333ea286'),(10,'Ubuntu 11.04 经典壁','https://www.linuxidc.com/upload/2017_11/17110121129468t.jpg','336d08de20ca717b4cec77bacee7c48853a87dc7c3fae90b48fb99ada0ca3ebe'),(11,'两张红色调的Ubuntu桌','https://www.linuxidc.com/upload/2017_10/17101508028369t.jpg','f9e84d959404048a87ca4f4964a1f5fa5ffa54f7a37088c042eeeef610048a1a'),(12,'红色调 Ubuntu 桌面壁','https://www.linuxidc.com/upload/2017_10/17100119589429t.jpg','3ca9071a9c7596aec698870ab8348377360bca709422ed8777051a9f61ac7952'),(13,'这就是Ubuntu 17.10默','https://www.linuxidc.com/upload/2017_09/170917084829721t.jpg','91f1ff989903a2576ed3db2241bdae7483427595839360afc3406795fc57f39a'),(14,'Linux LOGO壁纸 1680','https://www.linuxidc.com/upload/2017_08/17081909109536t.jpg','1c624154184ebaf6ac078c6886f569efaa379af727b43d20352749dc860ee578'),(15,'Ubuntu LOGO 壁纸','https://www.linuxidc.com/upload/2017_07/17072906518706t.jpg','7806303c34858c8771118196cfbf29e15fca9a7028ff21d591a93c871d930b74'),(16,'Ubuntu LOGO 壁纸','https://www.linuxidc.com/upload/2017_07/17071220006517t.jpg','0985f6dd6ccafacbf0021407d8efdb29b5002c53e325640deb96a7b0fb6d3daa'),(17,'Linux桌面壁纸1280 x','https://www.linuxidc.com/upload/2017_07/170701202019191t.jpg','3dc6548a5413b1ba205e86723dbc6a071bcfe90df34926383293eadf8a4edf1f'),(18,'Debian 桌面壁纸 2560','https://www.linuxidc.com/upload/2017_06/17061815409872t.jpg','b31b931e0485274e2c16eaada89920f0dc8072a111327b42cde1fe1f7f5880fe'),(19,'PCLinuxOS 桌面壁纸','https://www.linuxidc.com/upload/2017_06/170601070227121t.jpg','b0e724ae5b21c73faa2f7662cf5330795be2d26d5d7dd13eb085563ce0be1576'),(20,'Ubuntu Gnome桌面壁纸','https://www.linuxidc.com/upload/2017_05/170516122133671t.jpg','23e012bcf3a144dda10a35d1709015f46ad7e5ef9ad2da8cfc99fb46690af287'),(21,'多图-历届Ubuntu默认','https://www.linuxidc.com/upload/2017_05/170506153256528t.jpg','bc041b047116c8ee7ede1197b49bae05c1bcff68b43486b549aa389af6b8aa09'),(22,'Linux桌面壁纸 1600 x','https://www.linuxidc.com/upload/2017_05/170501222196041t.jpg','d3ffa7fc726613063d10ed0a7e1b383c4fa81c941ee95703012f15514005fbd3'),(23,'Ubuntu GNOME桌面壁纸','https://www.linuxidc.com/upload/2017_04/17041910005846t.jpg','fcb92eb86d74baecd909a94737df8765bc9dc20172a76e5b7adbb8b424d8824b'),(24,'黑色 Ubuntu LOGO贴纸','https://www.linuxidc.com/upload/2017_04/17040707284223t.jpg','b65a2cd5be27c29037ebfd1ca8462a03a0cd9d4ac41d7abdb74e0f192c2abb3a'),(25,'灰色Linux桌面壁纸','https://www.linuxidc.com/upload/2017_04/170401215748251t.jpg','0b8197cb232ef78c70cae07a3a4a9b15fd7719200e34ceba79962e378c311a37'),(26,'热情大红的Ubuntu 壁','https://www.linuxidc.com/upload/2017_03/17032611284527t.jpg','91c7276c70643a6c4fd0ee80bac41381e68f25fcbd5e83772ae89ed390081945'),(27,'印象派 Ubuntu 桌面壁','https://www.linuxidc.com/upload/2017_03/170301093673621t.jpg','f8b7c0715337c01d32778f0c80ad6d84028257f8e2b056a5a3f2039a121d2cd0'),(28,'Ubuntu Logo 壁纸','https://www.linuxidc.com/upload/2017_03/170301093341231t.jpg','7e31ac12506c71cf5997531549fc6fbed4ee409039295f7ef9ee5118a308f903'),(29,'开源壁纸Firefox','https://www.linuxidc.com/upload/2017_02/170206200040191t.jpg','bab516232d0e62b62bab2f78d53f77e3ea77f777110db33e94c01a61951e9732'),(30,'Ubuntu LOGO 3D 立体','https://www.linuxidc.com/upload/2017_02/17020119316734t.jpg','b64e77c169dadb6f170126eea6fe0373679943eaf1a90d35c250857eadfd0203'),(31,'Ubuntu 壁纸 1024 x','https://www.linuxidc.com/upload/2017_01/17011622236664t.jpg','fc7457c7065bc36ab98a2d25d08570a406383df8dbb32510ddb7f8539bb932a3'),(32,'独特的 Ubuntu 壁纸','https://www.linuxidc.com/upload/2017_01/17010121548334t.jpg','cf576a9b204e6f0ddd1b5a383888a5bea3dcab184a78431a16ca38f25403676a'),(33,'Ubuntu LOGO 桌面壁纸','https://www.linuxidc.com/upload/2016_12/16121322071823t.jpg','c92894bea2705cb7276f9fa1abb409dba87e6be433449011dc8a4b50d1265fb6'),(34,'Fedora 高清金属质地','https://www.linuxidc.com/upload/2016_12/16120121028725t.jpg','992523e5af2a204eca6b97769ee6de698c39d6e4a29ce261ad64966a8279f231'),(35,'Kali Linux 浮雕LOGO','https://www.linuxidc.com/upload/2016_11/16112811369909t.jpg','30c4ebca9c243d78adf6a419e7b8f3ff1e2cffceb1898a29ad46b25a5581aaf1'),(36,'Linux桌面壁纸分享','https://www.linuxidc.com/upload/2016_11/16110120151074t.jpg','d140102eb7ab628148c9bbb967185d9b063cea0948b0ad4a01698c0fd345071d'),(37,'Ubuntu 16.10默认壁纸','https://www.linuxidc.com/upload/2016_10/161008075993453t.jpg','757c8f7977a1a5cab8d5bbccd2fe87595ec8ac7f3dd18e09f65df7346248b321'),(38,'Debian 9 精美艺术壁','https://www.linuxidc.com/upload/2016_10/16100614496845t.jpg','2f27683284d14e3c4ea91d50305635875e94c2597c69aa03d8884d0a77516dc3'),(39,'Ubuntu 16.10默认壁纸','https://www.linuxidc.com/upload/2016_09/160911110679501t.jpg','43dca423402182f5b2c69f9998168a6c726a4a114618db8e5433e61ac93b58c8'),(40,'Ubuntu代号为主题炫酷','https://www.linuxidc.com/upload/2016_09/160903212574551t.jpg','bd1bd0a1e0a7a977711e82e0709a5b2ec4ed95964a4342d6f1729ab1cb644d89'),(41,'CPU LOGO的Linux桌面','https://www.linuxidc.com/upload/2016_09/16090120479526t.jpg','a418660420e25b6afc7974bab9d9efb65aa20ece14261e8d4213854a9641eb5f'),(42,'Debian 桌面壁纸 1920','https://www.linuxidc.com/upload/2016_08/16081811147949t.jpg','9e6c48d39cea5d7bf04001742d25aa7e35b12672116fdfd91e14adf0fca76828'),(43,'Linux吉祥物TUX桌面壁','https://www.linuxidc.com/upload/2016_08/16080922243580t.jpg','607f1843fa8d82dad704b4342979d9789eab9deae20ed33643c3183f562f2b71'),(44,'对称花纹 Ubuntu 桌面','https://www.linuxidc.com/upload/2016_08/16080221033356t.jpg','72fc7082ba1443d3d0a777b3f32971b43f26a2cd70b5fdcca53ad0526c7ba6a1'),(45,'Ubuntu Linux桌面壁纸','https://www.linuxidc.com/upload/2016_08/16080121167256t.jpg','9f1126a6767fd413ea6a6c157ca671448f61259227750e2cefd898032507faa3'),(46,'Ubuntu 16.04 壁纸','https://www.linuxidc.com/upload/2016_07/16071221507539t.jpg','3b5b5447e293e7f0649f364dbf4afe7f05803474c00082d06e22d7539244aa8f'),(47,'Mac OS X 高清壁纸','https://www.linuxidc.com/upload/2016_06/16060120276381t.jpg','648b468c775b2cffb250a0880dd46a412a9c12199733f28f1dfc5841ac78d759'),(48,'Debian 壁纸 1920 x','https://www.linuxidc.com/upload/2016_05/16051208336899t.jpg','6c0be4c978e3feaf507d5a1243f27fff44cd654e8337d65c551e7c0be9a61b40'),(49,'Xubuntu 蓝色鹅软石壁','https://www.linuxidc.com/upload/2016_05/16050721308074t.jpg','76988072dea24e92671fcd3245be39d5884c0f334e651cdff5f2d64dd913fdd1'),(50,'Ubuntu 高清壁纸','https://www.linuxidc.com/upload/2016_05/16050121387922t.jpg','3ae08011682c8b58db66cc3956d161fc257b6c3f048e064cf57ab106225b15a0'),(51,'Ubuntu 高清壁纸 1920','https://www.linuxidc.com/upload/2016_05/16050121287088t.jpg','4ab38fd632caf2c9d453cce438f0040f2384016afe0a7a7c86779f04f3e90711'),(52,'Fedora 24 默认壁纸公','https://www.linuxidc.com/upload/2016_04/160428164780956t.jpg','a1b9cc3293a10d23d9074cd96d95c70c00e2ed85024de7ed191c16cc5eca2606'),(53,'Ubuntu 16.04 LTS 默','https://www.linuxidc.com/upload/2016_04/160409142539212t.jpg','4ccec334669256fde451e179461e949ec755a0154ee7d144208383ae6a9af00a'),(54,'Ubuntu 16.04 桌面壁','https://www.linuxidc.com/upload/2016_04/16040120309573t.jpg','c4373882b826058063abe4b75dfef3966ab6b3cef27eb1313e45ed355515f8aa'),(55,'桌面端和移动端Ubuntu','https://www.linuxidc.com/upload/2016_03/160302122375513t.jpg','1006b9676292264e958ee9cea25310be0883849813ee553ec6c1bb6c6bb303e1'),(56,'Ubuntu壁纸 黑白调','https://www.linuxidc.com/upload/2016_03/16030121448740t.jpg','8ba1f5b943c33b401715ce3fc614558d6e0b5a576af98bd7e9151c308678511e'),(57,'GNOME 3.20 新壁纸一','https://www.linuxidc.com/upload/2016_02/160222140945691t.jpg','1ebbf15a7f41238c67b2ae5974875979b6383c961459617013eba31746878be4'),(58,'高清Ubuntu LOGO创意','https://www.linuxidc.com/style/systems/no_picture.gif','86dbc28a5f07e361ee9452d546a7af7cbd8761018b99ec1ee8acbd98dbf2b3e1'),(59,'Arch Linux 桌面壁纸','https://www.linuxidc.com/upload/2016_01/16011911251368t.jpg','3f158cffa711f440ad1d8e38ed5662094b013d8084c507cba27dc7caabb57774'),(60,'高清Ubuntu LOGO壁纸','https://www.linuxidc.com/upload/2016_01/16011614327065t.jpg','68bbcba21c0f2505594c8a8515b67dd2425cdde5d39c918da2ad53d5f5cf029a'),(61,'Ubuntu Linux 高清壁','https://www.linuxidc.com/upload/2016_01/160101200668901t.jpg','b15d9945355d0d01316dba4e4905036191456a7821f5b7544e00d6c30f572bf3'),(62,'可爱的Linux TUX 卡通','https://www.linuxidc.com/upload/2015_10/15102121064377t.jpg','fcb7933e4998d2ded89ce1e22416403e2203dfdf4167752af06251f21ae40cdb'),(63,'全新 Ubuntu 15.10 默','https://www.linuxidc.com/upload/2015_10/151008072895212t.jpg','36f57c389e23f1c9bf2905d175d6553c01a09802b5bfdb1c8e0f28714973c74e'),(64,'Ubuntu 15.10 默认壁','https://www.linuxidc.com/upload/2015_09/150921133681802t.jpg','c2a46ce307526aad6977709d5a3f3361888270606d6edc4e7e671992b0e1c6de'),(65,'SUSU Linux高清桌面壁','https://www.linuxidc.com/upload/2015_07/15072620452449t.jpg','5766775560d9ab1d2826f2f929bd419b2399c4ff7f7c0a22f1816183a68a1576'),(66,'Ubuntu Logo 桌面壁纸','https://www.linuxidc.com/upload/2015_05/15052410471317t.jpg','f1363fae174e3762db794316897cb9e77bff5cd800dd892b4161caa64768e6f3'),(67,'红色系的Ubuntu桌面壁','https://www.linuxidc.com/upload/2015_05/15050821422392t.jpg','c0f0ef7b610cbda1920748be9d1bcae292e185e553642203c1127f54bffd39bb'),(68,'Ubuntu 15.04 壁纸一','https://www.linuxidc.com/upload/2015_04/150415100353061t.jpg','32ab31bde74cbc09351b1f1801acbb42e1a3c36d16be8b33ccbd5fea9a819009'),(69,'15张Nitrux 4.15壁纸','https://www.linuxidc.com/upload/2015_04/15040920076380t.jpg','a0c7c21c88654c5ae5f85c7aae3be35d24277108396d01341b5227dcb2538f81'),(70,'Ubuntu 历代默认桌面','https://www.linuxidc.com/upload/2015_03/150316061522284t.jpg','7e7d49c1e4a193fd94bebeceb2c6248672e1045421c979b3dae0c6e45405df0c'),(71,'Ubuntu 15.04 新的默','https://www.linuxidc.com/upload/2015_03/150314062865062t.jpg','16d12c129245d8217e75f8b11dd0f0f6f95981e6de54c022cf0904675e859feb'),(72,'Linux桌面壁纸 1280 x','https://www.linuxidc.com/upload/2015_03/15031019233379t.jpg','df913c4ba5f66b5656abeca6aa197d96b7eea9d74e99413a4943339d1f86ab2c'),(73,'个性Linux企鹅桌面壁','https://www.linuxidc.com/upload/2015_02/15022220475186t.jpg','72badb2d9e9db1c4e526e486e85650e0daf06eb3b875afa64d96eea17882372f'),(74,'Arch Linux 桌面壁纸','https://www.linuxidc.com/upload/2015_02/15020810441483t.jpg','bdb5b0a37cb44e37e72348ece35faaea16f68029da51cd1c5259afb488bd9fe1'),(75,'Linux企鹅桌面壁纸','https://www.linuxidc.com/upload/2015_01/15011920499045t.jpg','d67b8b127116d57d635379be7f5f7bf275c0081d3502f4d664f750c4e2f53b39'),(76,'Linux Mint XFCE桌面','https://www.linuxidc.com/upload/2014_11/14110321028932t.jpg','a3cd0f6838b0f95dca238c96cf7df19e3da82fb5e1ac6ea29bb66c8a02a1acc8'),(77,'Deepin万圣节主题壁纸','https://www.linuxidc.com/upload/2014_11/141103091055292t.jpg','449d71603557aaf6df45bdae090e37a24c0fb400d447ce4d659fe0f8bb2dd3e4'),(78,'清新的Linux Mint 桌','https://www.linuxidc.com/upload/2014_11/14110119344848t.jpg','df0fd3b7c647b29bc376ddcdb90a707dbc7701d4eaac42ee080857c50597db68'),(79,'万圣节风格Ubuntu壁纸','https://www.linuxidc.com/upload/2014_10/14103119049730t.jpg','74684ce156d590a296565e5f36d5183c4e942e20e4b18046d7d6bcea219de4c1'),(80,'Ubuntu 14.10桌面壁纸','https://www.linuxidc.com/upload/2014_10/14102720535951t.jpg','edbadf3978e5e33a965ee31fd13b145483088e7f314a170135da2e214b41bf2c'),(81,'Q4OS Linux系统默认壁','https://www.linuxidc.com/upload/2014_10/14100718594829t.jpg','f95d4ac0fe03b427918107090a21d6c90d011f22cdef38ddaa174114dc868482'),(82,'Linux Mint GNOME 高','https://www.linuxidc.com/upload/2014_10/14100119235021t.jpg','704d12fdf50a2de7f140534035290e5ab09b89a625a86ba0dfe62ae6851688c0'),(83,'Debian Linux桌面壁纸','https://www.linuxidc.com/upload/2014_09/140922084112251t.jpg','cda9ab74d93204931c7ed104ad30bc62ec77d92731f756a19b0071dd582c4160'),(84,'黑客帝国效果版Linux','https://www.linuxidc.com/upload/2014_09/14091918465063t.jpg','4e07f3ee64bef6d146376b5bda6f0cf090499b2d34a8b12eccf45f0097e8cb9e'),(85,'12张Ubuntu 14.10壁纸','https://www.linuxidc.com/upload/2014_09/140911104498131t.jpg','d5e30610efe59639405138d8aa798716ebcb9b4c74a0470918d1d9a36764edc0'),(86,'Linux壁纸：冲浪者心','https://www.linuxidc.com/upload/2014_09/14091017281723t.jpg','eca22c4ef9421878da905a80a9d4346375c285440e973dda8602d15f841c69ac'),(87,'清凉冰爽高清Ubuntu桌','https://www.linuxidc.com/upload/2014-09/14090716515768t.jpg','ded564c29548bbc0ee4984594d9261fa3973107f90e15699868c4ab2ef674af2'),(88,'Linux吉祥物TUX纸牌来','https://www.linuxidc.com/upload/2014-09/140905214977801t.jpg','7c00ab42470656726fb8dd2779c28a9ca23ccd44014bc0b2106dd9b91e436839'),(89,'Ubuntu立体LOGO桌面壁','https://www.linuxidc.com/upload/2014_08/14081212342342t.jpg','5dba7dc0958faf52a42083765015bdc0d0df9775a6fb048a1aa94e390afe8f2a'),(90,'夏日清凉Ubuntu桌面壁','https://www.linuxidc.com/upload/2014_08/14081122005890t.jpg','4cec081d28316527405cc968be707e6b111f3a6a0ef71832f31430fa1632406d'),(91,'艳红的Ubuntu 14.10桌','https://www.linuxidc.com/upload/2014_08/14081019599450t.jpg','c2ff264eb0f2318419e64e91027c6c8166d285f72de02e702ff22901ae74bcda'),(92,'Linux桌面壁纸 1600 x','https://www.linuxidc.com/upload/2014_08/14080419246598t.jpg','fe40fa5d41b3394acbae383f3ce25bf3d2b72de9e502efd7ff608fa2df2d140b'),(93,'Debian壁纸一份 1920','https://www.linuxidc.com/upload/2014_08/14080317525753t.jpg','d8e254eb03c8435abe4ca705d37d62b707ad1335c0dd38e74f05a93b9cf3ec77'),(94,'两款 Linux Mint 桌面','https://www.linuxidc.com/upload/2014_08/14080116017065t.jpg','aa22651cb22b709037a7e0c54097e4521c4f2d989a886eb4a162e7bc2b928024'),(95,'Ubuntu GNOME 14.10','https://www.linuxidc.com/upload/2014_07/14072806561971t.jpg','5daabe0b0e3134251a47ba74b51a9b742f15f4628df2538a041bc485a22d6043'),(96,'漂亮的Ubuntu桌面壁纸','https://www.linuxidc.com/upload/2014_07/14070610107477t.jpg','c3780b789c2a77f0b7109d728d62c876c0ca28fcb69459e3db693b28b226893b'),(97,'Ubuntu精美壁纸：梦幻','https://www.linuxidc.com/upload/2014_07/14070410287312t.jpg','cd275aeba75a981e4b12ed77acc70fb61b4000613ce6f92495f61c2c766435e7'),(98,'GNOME 桌面壁纸 2560','https://www.linuxidc.com/upload/2014_06/140617111657281t.jpg','f0a4b5aa594d32ea3c56d9a9666d382cf7d3a47bdefb988feeeb8b2ad2b7cc9e'),(99,'Mac OS X高清晰桌面壁','https://www.linuxidc.com/upload/2014_06/14061619343695t.jpg','de3274fe3c44e5fd3a191a86e918f7ac411df46f053ada02b80cdbed76f1243a'),(100,'基于Fedora 19的Red','https://www.linuxidc.com/upload/2014_06/140612110978201t.jpg','8b40b5d1ea7f04befdec0e505843540837511eb88dd6df85a764a097607fbfba'),(101,'Linux高清壁纸：世界','https://www.linuxidc.com/upload/2014_05/14053110346173t.jpg','493df7bd936e28a1fca419c8bbb37e7dd9c790e96a39bb8632e65c2de2a24606'),(102,'Linux高清壁纸下载：','https://www.linuxidc.com/upload/2014_05/14052706045765t.jpg','d81aa8e55f09c3b07e0569d18f756eec052fcfb88cb212e569e2454cbc612789'),(103,'Ubuntu 14.04桌面壁纸','https://www.linuxidc.com/upload/2014_05/14052621507193t.jpg','9ab4aa5bbcca7801163bcb0db74ee4a8ab914efd82a59b74904f3ed649e9b8df'),(104,'Linux GNOME壁纸三款','https://www.linuxidc.com/upload/2014_05/14051016238923t.jpg','167fd208210093a4238693395a16a03e3f3d917ec224a190cc1b4726f9e216b7'),(105,'Ubuntu 14.04 高清壁','https://www.linuxidc.com/upload/2014_05/14050120505358t.jpg','ae2d2db6a740ca113557552bcacbcc0eb903c2d8cda5bb1721d50927687f3ecc'),(106,'Linux的目录娘【另类','https://www.linuxidc.com/upload/2014_04/140427192626451t.jpg','e004c90ac7185100dd88a0460097258c4ce787638e540f7ab751c3cbfbce33ce'),(107,'Ubutnu 14.04壁纸：可','https://www.linuxidc.com/upload/2014_04/14042217055447t.jpg','310b2eacb5e0e21e4b4c570f7a9261f50bd3c9154640134c0ea15589115f4109'),(108,'简洁的 Ubuntu 14.04','https://www.linuxidc.com/upload/2014_04/14042216581928t.jpg','54d4e23809b75b62155873d4696d507ff120b75eccb9d26473e014e0178e77f0'),(109,'Xubuntu 14.04 更新默','https://www.linuxidc.com/upload/2014_04/140405085727478t.jpg','3b6ca8caeb8733e68cce44cc4b9e1d255b4aadf8347ca772f729972e63fc2aed'),(110,'Linux Mint壁纸：绿色','https://www.linuxidc.com/upload/2014_04/14040420415679t.jpg','de872d03eddf2daf124c5e2696c591ffd7c9017a08113fc06bbc9c3bbc7acc9c'),(111,'Linux Mint壁纸：童年','https://www.linuxidc.com/upload/2014_04/temp_14040218027522t.jpg','3bd066ac2b7dac9b8f7193dc9eda6d6ce024a0b4d468a1239635e0de815cfa86'),(112,'Linux Mint壁纸：明亮','https://www.linuxidc.com/upload/2014_04/14040217576905t.jpg','a223d6b44c35bc950fdc24fea33e522acf5ecdfb76e7cf67b00d85c6500d4af4'),(113,'愚人节送出Linux高清','https://www.linuxidc.com/upload/2014_04/140401083165312t.jpg','48812f817ebe9a707d2aae1949c8bcf94b902682349be174c2c8685083369db8'),(114,'Ubuntu 嫣红的壁虎壁','https://www.linuxidc.com/upload/2014_03/14032818556790t.jpg','eec75be0efa890e0e795acb5f53455a152e28c0a0ea3e5b5497fe2210f277d3a'),(115,'Ubuntu 14.04 壁纸大','https://www.linuxidc.com/upload/2014_03/140325170450721t.jpg','87fc7557521db773297a1ef2a15e6717e007ce7f8c470d637ce2547ef9dd7dd4'),(116,'Ubuntu LOGO壁纸','https://www.linuxidc.com/upload/2014_03/14031918393578t.jpg','1d52d14ccc7e645d674db85b14f2a1d7e4370761636a17c1a3ea4f327c9bc38f'),(117,'Ubuntu 14.04 LTS 采','https://www.linuxidc.com/upload/2014_03/140312133855671t.jpg','0a188cd333885fe202f259fc213a19e64ffdffcf0150e79149cfd3fe4078527f'),(118,'Fedora Linux壁纸','https://www.linuxidc.com/upload/2014_03/14031118429148t.jpg','7004b5339002b4d1a4dfc9c4307f42ba1124d48391224f768d903f6dc4399d8c'),(119,'Ubuntu桌面壁纸高清晰','https://www.linuxidc.com/upload/2014_03/14030709597845t.jpg','58bfecd5f7f99cb4c6131c48a3d25389fee84d7fb058128fc4c3073df4804d41'),(120,'Linux 桌面壁纸 1280','https://www.linuxidc.com/upload/2014_03/14030516446965t.jpg','ae0159928e1c2e34dd839f05b18d1d50ac888fa1e86f274e9286bb676194dd4b'),(121,'Ubuntu 14.04 壁纸大','https://www.linuxidc.com/upload/2014_03/140302125393085t.jpg','8d404ec9fe8702f8618dc01d7888b72195dc12054218755ff18cb24711f156b8'),(122,'Debian 美女桌面壁纸','https://www.linuxidc.com/upload/2014_03/14030211418164t.jpg','4c7435f26e45eb66872d9bc918486ef07911691ae0bc004dc684cf3e06e7a09a'),(123,'Ubuntu 高清桌面壁纸','https://www.linuxidc.com/upload/2014_03/14030122075028t.jpg','e8e4a4fbef46b6cb576ae4aebe0611ad8258f29a2646bb6d379aa1cbb011a49c'),(124,'Ubuntu 14.04 高清桌','https://www.linuxidc.com/upload/2014_02/14022421043570t.jpg','f93e1eefbc4d1cabeeb9fd4096e3ba4143995cafd7e1fd78ba6cbcab883399e6'),(125,'Debian桌面壁纸 1920','https://www.linuxidc.com/upload/2014_02/14022213386228t.jpg','1553911c255774571d4a4949934319740df8198d0bf77ecdc0d08a0921dd38d1'),(126,'Ubuntu 14.04 桌面壁','https://www.linuxidc.com/upload/2014_02/14022112143044t.jpg','075f1e9ec412735a02a0ed796fe3a4def028a13b28dd58436a584ec3284706f4'),(127,'Ubuntu 14.04 桌面壁','https://www.linuxidc.com/upload/2014_02/14021919393031t.jpg','ecbd52156740ba10a061f1e41cbef1d887fa70c2ace61ed3dc78452c85f266c6'),(128,'XUbuntu 社区的壁纸大','https://www.linuxidc.com/upload/2014_02/140203091971991t.jpg','98294551f33f1f00216cbdd58f12c4f2220044dbbac9bd0d84967e54c33a3af5'),(129,'Ubuntu 14.04 高清桌','https://www.linuxidc.com/upload/2014_01/14012819186670t.jpg','b8cb6d138b4f41069946059e655e835d9ef30269a654d3638ea1691286ab7b8d'),(130,'开源Linux桌面壁纸一','https://www.linuxidc.com/upload/2014_01/140113193295861t.jpg','20417eb2c71af71cbba4f33de974618b8c12ffce9ad5bd1aad1952dce9b64896'),(131,'Linux 发行版 Mageia','https://www.linuxidc.com/upload/2014_01/14010119383697t.jpg','160b7b08d69e397b06ae07dabe50b072467400e70826c0bc1c80101b8c994673'),(132,'Ubuntu 13.10 桌面壁','https://www.linuxidc.com/upload/2014_01/14010113304914t.jpg','71ad07a5e464db256a884340a6eb0f8a5cac8e2a134ec0eeaa0f0c1bdca027ef'),(133,'Ubuntu 精美壁纸集锦','https://www.linuxidc.com/upload/2013_11/131124083563112t.jpg','fe9b212680746f2e14512cd2ebcbb427933c764de07c7cb8ad41ae3a66d68913'),(134,'Mac OS X 壁纸 1920 x','https://www.linuxidc.com/upload/2013_11/13110220227103t.jpg','302b231e8c5276d8be243f574d11f38f5862218d938478e3a658036e2831e8dc'),(135,'Ubuntu 13.10“俏皮的','https://www.linuxidc.com/upload/2013_10/131014090530871t.jpg','dd3956ca95accc567d687815d24bdc669a1ee3882906158ada643a34c244c1f6'),(136,'水墨壁纸给Ubuntu 13.','https://www.linuxidc.com/upload/2013_10/131011212769321t.jpg','3301973dd0483380ef0270f20f290df07c2aa69390bad207066bc9051c4862ea'),(137,'一套清新淡雅的Linux','https://www.linuxidc.com/upload/2013_10/13100608038025t.jpg','afc8d78f6b8807c881ebff82b87d61a5138d550ef4183a9a388408513f6a626c'),(138,'Ubuntu 13.10 桌面壁','https://www.linuxidc.com/upload/2013_10/13100410472393t.jpg','2bef0b1a628edd97c7f9f2677e2ce79057bf2b21724aba920c8f6134a6d3e433'),(139,'Ubuntu 企鹅桌面壁纸','https://www.linuxidc.com/upload/2013_09/13093020594272t.jpg','f60100f580fa00882d167a341a356ad574cc8cb9a58c904cf8154033180815e3'),(140,'明艳的 Ubuntu 桌面壁','https://www.linuxidc.com/upload/2013_09/13090709143491t.jpg','f6867e239458e6c7f19b8b33f9c540d46ae2adaa159d4b94b9325e7cea2025cc'),(141,'一组 Ubuntu13.10 “','https://www.linuxidc.com/upload/2013_09/130902064043211t.jpg','98150a5d9056aa0e553fb487e5456b06371207ab0acc38a4349528e7436ff304'),(142,'Ubuntu 13.10 桌面壁','https://www.linuxidc.com/upload/2013_08/130826131930651t.jpg','2d233c99161b59076c15a5a33d979fbeb6ce2588b45ba02991e5bab17f5717fd'),(143,'黑色调的Ubuntu壁纸','https://www.linuxidc.com/upload/2013_08/13082115476381t.jpg','df1ee28bf16200c82006e406d15f7752c1733d335412c2092224a44cc7e57852'),(144,'Ubuntu 13.10 桌面壁','https://www.linuxidc.com/upload/2013_08/130816060776461t.jpg','ad0a2f57df4118d1937fbf63662fd1ef84ae9b4037e3497b760a7750b6a3896a'),(145,'Ubuntu 13.10 壁纸大','https://www.linuxidc.com/upload/2013_08/130805225740772t.jpg','9d3b2493dd126e298f749df686068be1e4b28e095e786d4d12ae5605b2328dcc'),(146,'Ubuntu 桌面壁纸 1600','https://www.linuxidc.com/upload/2013_08/13080317299450t.jpg','be0dd60448d59e064da6fb5d1ad797a89722a3ba939a896d19468ced8f3b9be9'),(147,'Linux Mint桌面壁纸','https://www.linuxidc.com/upload/2013_07/13072421579767t.jpg','35fe85ff943c4bc37e16c6caf7c2ebad4df866fd39004691fa222854c0ad6a91'),(148,'Arch Linux桌面壁纸3','https://www.linuxidc.com/upload/2013_07/13072006029734t.jpg','25680527a6d8eae9a81242ef69e31b2864ca4776ecd3e2cca15baeb67807f6b8'),(149,'绿色养眼Linux壁纸2款','https://www.linuxidc.com/upload/2013_07/13071410361560t.jpg','82c68e6c36e243ed65d40690c7ada6bf1418cf75f8aaee4b9f3de3137169360f'),(150,'Ubuntu 桌面壁纸 1280','https://www.linuxidc.com/upload/2013_07/13071210032079t.jpg','4208811b91845bcf605ed3033324213ac67d2fd34fa9df52bf9d47a6735ad23f'),(151,'神秘的 Ubuntu 桌面壁','https://www.linuxidc.com/upload/2013_06/13062621267520t.jpg','23a1e067aed7c1bd43bce8d1ef3f51fe933cfa9f287589301275625d54716b6e'),(152,'3款灰色调的Ubuntu','https://www.linuxidc.com/upload/2013_06/13062209014198t.jpg','72222925f5ffbaaa79c6f275cb97241f7f5106cf98054c0ad30c63710453fc07'),(153,'Ubuntu 桌面壁纸 1920','https://www.linuxidc.com/upload/2013_06/13061812497867t.jpg','da700b1ab54b8e4c888564e470d6830df24c4c9630c51f46d819c31cd7046374'),(154,'Ubuntu 13.04桌面壁纸','https://www.linuxidc.com/upload/2013_06/13061614263510t.jpg','a99709b6e933df7ce11c08e50e61cfde5387401af53d9c8c16bba24959e8f4f7'),(155,'Ubuntu 13.04桌面壁纸','https://www.linuxidc.com/upload/2013_06/13061614238257t.jpg','cdd212b512e7630bbfa9ced77f7c59b0629abfb3cd5cef6330a070e958a8317c'),(156,'Ubuntu 13.04桌面壁纸','https://www.linuxidc.com/upload/2013_06/13061019456899t.jpg','2f078ab101d9e7f7383720b7142e1182015f90aa4cd8cdbf0bd5e5de8862504a'),(157,'飘逸字体Linux桌面壁','https://www.linuxidc.com/upload/2013_06/13060110325299t.jpg','e15089c35663e440e1ec783d8481ec421ba220774556a044a82769172c48b222'),(158,'红黑白配Ubuntu壁纸','https://www.linuxidc.com/upload/2013_05/13053111396238t.jpg','3c278d79fd075429604c6c162686f558f2fba7c43ced6344d0b4e6efdf237c2c'),(159,'Ubuntu 13.04 壁纸分','https://www.linuxidc.com/upload/2013_05/13050719389293t.jpg','7d2fecf5a98c79fc7e513bdff5f7fd24d8ee318e4e00e762299c631bd3bad954'),(160,'开源Linux系统壁纸','https://www.linuxidc.com/upload/2013_04/13042915127221t.jpg','420d6cdb31bb3bf65458dc4b1a6e9dbf8f7d0aa0e93a0dcc909a8bf0381a4ca7'),(161,'Ubuntu 13.04 全新壁','https://www.linuxidc.com/upload/2013_04/130425202014161t.jpg','35c39071e25fb4ad2e1be86e5157b73967ee753e080c06448b5964ccd5be85ff'),(162,'Ubuntu 13.04壁纸','https://www.linuxidc.com/upload/2013_04/13041115546435t.jpg','af610ba5ef4dcaa42e4c44e8e8d79eb77775aa7786ce03e375c93958ee5eb244'),(163,'openSUSE 12.3壁纸','https://www.linuxidc.com/upload/2013_03/130325190475721t.jpg','be9624f409425ab3a12308707ba8d0467ec712a053135f8b1706fdcc1a37f9aa'),(164,'Ubuntu 13.04壁纸包发','https://www.linuxidc.com/upload/2013_03/13032011498833t.jpg','9cbd9523a133970a486cae4d733ed071a8160175790ce828d87b775508c0427b'),(165,'Linux Mint桌面壁纸','https://www.linuxidc.com/upload/2013_03/130319091961101t.jpg','9869f6a019637d84c4019c33579e8ad24991af0f7c6b8d78902e79748dc91a1e'),(166,'Debian Linux Logo桌','https://www.linuxidc.com/upload/2013_03/13031716238147t.jpg','88567681e3f3f787296d53539ce9b8c23cedf43afa446dc6f7afcf5db90b4473'),(167,'Linux高清壁纸 1024 x','https://www.linuxidc.com/upload/2013_03/13030519324842t.jpg','f6dce80e72732dfb031687f8c1757487dc8050023b5f06585c73734aaeabf7d6'),(168,'Linux桌面壁纸 1280 x','https://www.linuxidc.com/upload/2013_02/13022616045603t.jpg','be4d2e94642ef678510b40c276020b2451ea1c7937b4d43c8427da2db9244722'),(169,'Linux桌面壁纸 1920 x','https://www.linuxidc.com/upload/2013_02/13022516038025t.jpg','b697613547eea0ceed94f31ac83de27d65802bae345a5f38fae12fc9f0af57de'),(170,'Ubuntu 12.10壁纸','https://www.linuxidc.com/upload/2013_02/13022420016815t.jpg','d31a8b204d5ab6aadd204ad45f645956ffafff3e2b3c5ed1c06f5be31150ed0d'),(171,'Ubuntu壁纸 2048 x','https://www.linuxidc.com/upload/2013_02/13022318153829t.jpg','db7fedc443148b0f547fc16309af205f863e15dab8cf140a0e767e50492b0da4'),(172,'Fedora Linux高清壁纸','https://www.linuxidc.com/upload/2013_02/130222091022101t.jpg','45dc1182befef44e58ba0a3a5cf98262a18c2356b5632d2ba98fec2bf884bc98');
/*!40000 ALTER TABLE `linux_wallpaper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-22 17:38:19
