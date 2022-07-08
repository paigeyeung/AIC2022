package wtest_evolution;

import aic2022.user.*;
import java.util.Arrays;

public class Troop extends AllyUnit {
    Troop(UnitController uc) {
        super(uc);
    }

    // x input -> 16 hidden -> 16 hidden -> 9 output
    final int[] LAYER_SIZES = {25, 16, 16, 9};
    // Weights are outgoing weights
/*weights_start*/double[][][] weights = {{{-0.7197690534077683, -1.64938270379962, -0.3458475051230465, 0.06609674745326632, -0.6621472206214478, -1.8186268708911282, 1.3184139394936247, -0.8047689395354527, -1.9246414575294306, 0.4619647011864667, 0.4201200439501407, 1.2122949466904651, -1.2488323637533862, 1.215003778455432, -1.500714083801006, -1.9262820722872016}, {-0.21876239482028215, 0.9375957808359745, 1.1733991605391125, 0.254886621278708, -0.23156390979944286, -1.4433915827324224, -0.6641610219567888, -0.2020479902646688, 1.4953632472391987, -1.8842228403496368, -1.750928272054106, -1.892570110998253, 1.8761368652407384, 0.3412097169456123, -1.081033899217056, -0.3436267374643833}, {-1.0345155135904367, 1.9544712387135679, -1.1664500422295307, 0.4943231211062469, -1.3596692455319226, 0.46398147300028914, 0.9883125919317997, -1.6679488724248643, 0.10523772920972485, 0.2667777677687191, 0.5341690915394737, 0.035982692387906745, 1.2002526404863985, 1.0551700769905055, -0.44366024761487344, 1.0710470868338553}, {1.285927640827412, -0.5337449184863914, -0.534215535340754, 0.2829945311314579, -0.7183421268507759, -0.6373477045796556, 0.2229739143766416, 1.7190112347296043, -1.9767598135166589, 0.9889221327358211, -0.7619528932351902, 1.2532672280879606, -1.6119745350576147, -1.7228285335802447, -1.59553603043523, 1.063612363061837}, {-0.3427698764491831, -0.5952131089801611, 0.42871625563217686, -0.016699009360752637, 1.8540291726297884, 1.5513087058102224, 0.2453419491733686, 1.971653578516051, -0.9524679916551761, 0.12470098662214557, -0.044240738916493605, -1.6951936162124581, -1.265839153696307, -0.9446669779102597, 1.285184605145493, -0.5401406276303011}, {-0.929558713201835, 1.104799375759058, -0.2708184148055004, -1.3419988502560232, -0.3354553074103084, -1.0604497922011547, -1.1953536456283231, -0.8761151599361785, -1.754596461448298, 0.5788720241908276, 1.7014610820201304, -1.6096493107583263, -1.6778493719196788, -1.3020828046950679, -0.9520384117427634, -1.0667593991110844}, {0.7732029734607537, 0.7916424037838281, -1.366912461305152, -1.0291383272196115, -0.7942021161469142, -0.3662388824924516, -1.0463077936114753, 1.5076881527462276, -0.9383559826916716, 0.11661706947404982, 0.1591847346494384, -0.25349478804756176, -0.5818258208638305, -0.34986103949035563, -0.44728151822550366, -0.980701714447096}, {1.630059732887891, -1.8565533877368803, -0.5393516128719167, 0.8969043490044029, -0.2905677990236146, -1.042767371322097, -0.02959512021025068, 0.5052369968456971, -0.9736935287220194, -1.9420979239100271, -1.305550286362947, 1.4421479118485956, -0.31121259026326253, -0.7029969564364658, 1.3762756976315353, 1.4330960784771265}, {-0.2775613745822283, 0.7095094395560584, -1.3147814983605732, -0.6286972911698037, -0.185573079878528, 0.5328615911477717, -1.113255492334312, 1.7113016559029584, 1.9978815311198228, -0.8370443177781985, 1.1723642687424691, -0.7623011056781555, 1.6565708990786945, -1.7778599875823886, -1.58571966069161, -0.4720322587950352}, {-1.3553739638014255, -0.6291936191882774, 0.7943624401432414, 1.5438936190104942, -1.6857693950106545, 1.6105107766340163, -1.670330545023861, 0.03184984755561393, 1.090145509393046, -1.9249846283600593, 0.8266925178652467, -1.282000003398991, -1.1959185154501082, 0.12649700407116748, 1.1486652782685787, -1.57533537280068}, {0.3213687207804683, -1.2344979919735777, 0.6635795084701388, -1.9159032048791818, 1.2522932108887619, -0.8497850956280022, 0.04029821222472707, -0.2523976933922678, -1.3716293441366596, 1.0577827588631252, 1.0756410420112363, -1.6951957500795714, -0.7549261195716039, -1.8825990697854325, 0.2500591991253014, 0.9329423143208992}, {1.2930561169347587, -0.11660640734055194, 0.7379453493190438, -0.600302080209163, 1.2107469740725416, -0.18950549369176262, 1.9008778693553445, -0.5698102534884697, -0.8982433858189447, -0.7066452888357406, 0.5385951117209204, -1.24062915590235, -0.40194247213430767, -1.6063360241610947, 1.3297354329994353, 1.2587418787911901}, {-0.19018493827057537, -1.3692368170333475, 1.2306545432242948, -0.1647881323132494, -0.2332124409305405, -0.05740346387168849, -1.3528957606373746, 1.7144929117757948, 1.5151078428047051, -1.4121691472529445, -1.4093932589794695, 0.43237448756734853, -0.5788254713121823, 0.19450467914310732, -0.5846431716534206, -1.139453910447005}, {0.32921531466160747, 0.24832425808178904, -1.4460197727286586, -1.04165454694219, -1.3468103527049236, 0.2957701721307866, -1.5265701531783908, 0.8903719558741097, -1.2765614437558903, 1.0782304503466151, 0.16661473300995322, 1.9058900626003825, -0.008206863569594436, 0.39038386974705475, 1.2907419604871695, -0.33428394668579653}, {-1.2887378745343159, -1.2750775079012477, 1.4943876611288225, 1.8914719900627683, 0.46574897932454373, -0.8864398534406561, 0.1237201505055654, -0.5064285406866249, -0.24972836458594738, -0.108208707684041, -1.3475160635805996, -1.5751941958692837, -1.8689738916423035, 0.8514318305554882, -1.0166495328722536, -0.6085234265096378}, {0.03693606555274087, 1.1366079942356317, 1.6083337695729596, 0.9560080159933664, 0.1720088488351159, 1.339109912408008, -0.4319575093754251, -0.8008412349575513, -0.11537926893782435, 1.9293622421339567, 1.9660881530582959, -0.2874630925146935, -0.2645557059581707, 1.941095952291536, 1.1287998690813454, 0.10042118019874868}, {-1.5105864799471274, 0.5703527248973836, 0.31509337585044994, -1.2839277118271744, -0.3255864818894616, 1.09173002871308, -0.47380625786444774, -1.7553640596340885, 1.8478549660353227, 0.6023097891270366, 1.9643774423731077, -0.5957726112933992, -0.14032586943842684, -1.3425435586356325, 1.3252071254869486, -0.40917185649353893}, {0.3561225303036384, -1.6884361677080197, -0.8568623079176789, -1.7204960783545462, -0.201749394360502, -0.9366325365880597, 0.5059576784405597, -1.3044099908256919, 1.2245188326167185, -0.24407877255353805, -0.29220341769647273, -0.4693357667141762, 1.8750757245517025, -0.2738184000200601, -0.5736809930559668, -1.6499582382646247}, {-0.669517138914467, 0.4222778011085242, -0.24251588932700852, -1.5724609309201059, -0.30141797668521075, -1.785802670173764, -1.176437949827875, 1.5518546363178816, -0.7161586803551208, 0.4766089609412085, -1.3595433286641092, 0.9034331305225933, -1.3250091089006895, 1.4987375495889887, 0.5535289396390146, -0.36455175601803536}, {-1.3121412993845607, -1.481363933394125, 0.8677821980127591, -0.8813444292494483, -0.1855207881608214, -1.0445202592863003, -1.4749778158913869, -1.363982318245577, 0.8996856230341637, 0.6875304192898177, 0.7836307710150621, 0.8528042535268376, -0.589133619800204, -0.44066244250254627, 1.975436259337687, 0.4981597450936639}, {-0.7343672663692113, 1.5181865766404492, 0.6849383199998731, -1.7154946370379833, 0.1847469371713868, -0.5657514775950556, -1.5109895703103966, 0.7252404070874277, 1.4763359282127668, -0.8790799565688072, 1.394587931574272, 1.0698579866512348, -1.3972532688746546, -1.2571077470324328, -0.3762280386419472, 0.5364808798713883}, {-1.934445084099587, -0.33408556881452167, 0.5200614569220372, 1.4082202809365434, -1.6810915231562413, 0.356564162481686, 1.2062904021872765, 1.6327982193920714, -1.2877119433278281, 1.5745509427728233, 1.8146580668405434, 0.9455377207492992, -0.008971416711497593, 1.1083776992791718, 1.8197219069810577, 0.5817020808826805}, {-0.8334144156588121, 1.578513195380188, 1.9062963444279637, -0.689183595514403, -0.8144524149634136, -0.9241582420662109, 0.8051814057034039, -1.6100789354372163, 0.09298675032566805, -1.9857760223899383, 1.6773262456656002, -1.6040308818714388, 1.0621906580245337, 1.364569977392557, 0.49740040837661503, -1.6334054086000065}, {0.8486680083457645, -0.7514564038884992, 0.6612094925486307, 1.3980427992296236, -1.293687692339161, 1.4860266170695366, 1.1862577554029379, 0.1351862654433731, 0.9483046255775185, -1.0027026625455568, -0.2305749144234448, -1.6781427592256644, 1.6958309689606392, 0.4066523210683797, -0.023597847250903747, -1.6228292425070894}, {1.749310904109922, 0.6460468794331304, 1.8326318250672289, 1.1131265802386046, -1.7466684397625736, 0.7005983640781102, 1.9485059974229988, -0.6282220901357505, 0.4601150299319978, -0.282732979673336, -0.320114310964299, 1.5246367192068417, 0.5112885377095635, -0.4701126122359076, -1.1190831292331773, 0.012875379250365526}}, {{1.0206023511923301, 1.9837051345835595, -1.2080037545519966, -1.0314474724238756, 1.3423692070696949, -1.692927730887794, -0.28418066719830737, 1.277107379995516, 0.0169698619635561, -1.762209722283215, 0.343831623317882, 1.12305116131231, 1.9091952836707615, 1.1528232153099203, -0.9605325270792067, 0.3706898798015654}, {-1.8053731564990292, 1.2419278373651088, 1.2310096556803178, 0.6855315639638637, 0.8433008315891444, 1.4807726197554065, 0.34336926031449355, -0.9695252154185323, -1.6006105699504078, 0.9872207664451813, 1.4748035986324242, 0.25550314406065455, -1.246367652919742, -0.04644347856712017, -0.5349963469883261, 0.07718081009373634}, {-0.801205309949061, 1.8926757566615553, -1.5180853112544503, 0.9438475746003672, 1.9491951838441288, 1.988860722811571, 1.272212620736184, -0.9385362819985894, 1.5204491172782486, 0.2720681333334385, -1.763085817723557, 1.7284919620708425, -0.42098534559035183, 0.1351123692532803, 1.3023557679727005, 0.5213903816928975}, {0.8759248138648608, -1.655421638414731, -1.780654229662252, 0.047997113434340655, 1.8726182500294954, 0.2752691206429936, -1.4119175546337095, 1.4393429097311161, -1.7526370218983236, -1.0854050843623444, -0.9767087011376177, -1.231184040073419, 0.4290788391517997, -0.7079187392954185, -0.08358601362988693, -1.8887592910541424}, {-1.1338895111321232, 0.8286828438421754, 0.30817561490365764, -1.339175564605179, 0.6900729304688005, 0.9766805606269893, -1.432429515798633, 1.451376617162118, -1.6808524193876933, -0.7494946158969822, 0.1981410266734871, -0.8051127633777835, -0.15648371514820836, -1.5228779822737355, -0.2604864740039421, -0.053098908430705194}, {1.1463592231347617, -1.3751183166970118, -1.3718428675176977, 0.8186524312347085, 1.3335311680357216, 1.4358763777261414, -1.8653736651399417, 1.611736170099912, -1.9240289361811196, 1.5454554298867444, 0.9887425597836406, -1.8934378292166651, 1.7287687165745576, 0.747692770878972, -0.38638602306968384, 1.1059645823321937}, {-0.6386490913839258, -1.3927186781280385, -0.2059072939186617, 1.2550523205875117, 1.7604006719831502, -0.6705759562609179, -0.8793346427777435, -0.7067345648422481, -0.9713707897153676, 1.6596638636250423, 1.712874066582048, -0.6269283853709102, -1.7028907202639005, 0.48339145964550667, -0.5490370935313402, 0.21482398257054447}, {1.435421643577552, 0.941525491113846, -0.6569904051688167, -0.9115224440677063, -1.9072771491995124, -0.22935942608321458, -0.7540357550716696, -0.7737487313702718, 0.5629350514571039, 1.3885447431568965, -0.6080162353538996, -1.018712325817806, 0.8228213522356396, 1.474841995595189, 0.770742422314374, 0.8981962197540714}, {1.557875534463729, 0.04140338619669359, -0.11194709882028775, 1.3482915715752788, -0.4042242966477807, -1.189304514849276, 1.508000171143919, 0.23352244401200695, 0.7219776983474588, -0.7350405307187895, 0.5234753432320689, 0.6250189445023131, -0.3367657989141053, 0.5717540732726838, 1.3184199273773083, -0.1806288040789652}, {-1.535279011489671, -0.8157347490220634, 1.0529699777827846, 1.1261223876569186, -0.9937868825867411, -0.32382911221820665, 0.43354576053337324, 0.4857655782133983, -0.7136152671398972, 0.6127256749651657, 0.0868580163744217, -0.6760465503858084, -0.9273444482664721, 0.16828097887750904, -1.6828510010098192, 1.969744053949456}, {0.47624400512427556, 0.7426658203722067, 1.16668227170211, 1.1307666637520093, -0.08214176125177142, 0.547160907235464, -1.8511319025438593, 0.23791899148440265, 1.6658159488680302, 0.3209793823843645, 0.6489268461606152, 0.4850741249051511, -0.26884305606797776, -1.472917557049814, 0.25069520232469555, 0.07067619467357122}, {1.1859943892332905, 0.6181250967974385, 0.43444906116319437, 1.820035529162813, 1.8739069542499052, -0.3859876997330902, -0.1416836859377555, -0.37199994809170267, -0.31385657955738067, 0.1524329578972976, 0.9964974099393209, 1.1115181699589445, 1.0322707280855017, 1.0546377165547054, 0.3142512915102831, -0.552729215570738}, {-1.695158541331259, 1.3891721149625145, -0.4697151120529166, -0.3079158252678944, -0.8150809703180841, -1.9512622407875515, -1.8797356264530416, -1.30282082291883, 1.5920919877824886, 1.8146829533794064, -0.6603754631701202, 1.9420709460849572, 1.4533868549811881, 1.5106708454657207, -0.6059524820056983, -1.3872634136585984}, {-1.166217141582337, 0.5389252933297661, -1.6085129035805958, -0.014673728606738212, -1.865341658162901, 1.7517566289893578, 1.7688763822100557, 1.6419559685261245, -0.5721170888782843, -0.5988284697689967, 1.6667495366887857, 0.0289348961753797, 1.0185699592713204, -0.31725563946615676, -1.6989110561667236, 1.6859418379417876}, {-0.49179038058735447, -1.1320146791312573, 0.07211856494192803, -1.6203185204453008, 1.1554708096446813, 1.032293880420951, -1.9783954575265135, -1.9444185372917704, 1.098389397764961, -1.1567843177607204, -0.09495093131263266, -0.5293449276254143, 0.754070398329052, 1.9818794122290528, -1.530084204474702, -0.8648316990329907}, {1.4704231245015666, -0.38195170645340815, 0.5800260175128602, 1.8952270118126702, 0.7216448711913825, -0.6390124036370457, -0.12047402948707031, 1.8650333321165662, 1.207796694183072, -0.7848287566094525, -0.0558428628726233, 0.2773659493318301, -0.5913376846416196, 1.7061241743950508, 1.695000756981507, -1.4562471525202616}}, {{0.8961313953077372, 0.5419778178454795, -0.6623343341546297, 1.585873624626101, -0.12032347691984269, -0.07604614829533762, 1.2572906074866181, -0.9484731309996755, 1.3933883119610035}, {1.8774628138128593, -1.6988994655561807, -0.8694259021239286, 1.6327197753307336, -0.19053409903664198, -0.8165445963124038, -0.7679624682586916, -0.3046229894941552, -1.814152925725141}, {0.6763925216428097, -1.3929911449780268, 1.777991125836814, -1.9397697180369966, -1.6016995776146223, -0.2887006905469809, 0.9136437061778739, -0.22395416105682964, -0.06092042531546449}, {1.019605381762429, -1.4376136240089314, -1.544544516592822, -0.21923767818006556, 0.9048383124969597, -0.13338093509792204, 0.9089648359316516, -0.1513901802496096, -1.0877027074472383}, {0.5405329408479189, 1.558075803210873, -0.11620727806166675, -0.8818207115740981, 1.9752499051261085, 1.5392103967718374, -1.9006890184386274, 0.03050444969053956, 0.7243379727383328}, {1.7790228368567003, 0.8982031047932084, 0.5876329054423324, -1.017426494408066, 0.9514296017739867, 1.0852575495598331, 0.43407262371794575, -0.8863127434292939, -0.3024951600401775}, {-0.4566182847696223, -0.8992428660468574, 1.864132641179102, -1.9321527842481743, 0.0866096928136737, 0.566027857120988, 0.24296641038218691, -0.43058258430275265, 1.4899925392023392}, {1.6558321645720757, 0.21551059731900812, -1.6704221040502856, 1.2945370629408597, -0.7022000769555636, 0.6580581743991218, -1.5321729293517508, -0.8087906517644021, -1.5629582946523652}, {1.4650033336689892, 0.07330529880508418, -0.9688606189181681, 1.5937273516843256, -1.8454895450548805, -0.20509549117892734, -0.6283936699921213, 0.3650056425362638, -1.3256629397294777}, {-0.57450437525601, -0.18258859752024836, 1.9674958289806033, 1.3960976240572864, 1.5868189344892496, -1.3391481343430565, -1.8310408543137546, 0.69959987947282, 0.026697499748282727}, {0.7159946110632118, 0.7214182254500283, 0.26798862711988747, 0.157445315682482, 0.7806692676672675, -1.4968183347327, 0.44659053937752446, -1.249708238686766, 1.212221765528417}, {-0.39571061495809046, 1.6204143224948284, 0.7753903018453134, 0.34876198493927957, 0.41302698902857493, 1.2081439274311574, 1.5748622131900434, 1.293860503936438, 0.07014192690749299}, {0.7695165972429381, 0.13988648364268474, 0.386448850286246, -0.41620918801149065, -0.19957054429364796, -1.9395185531016104, 0.8541662730969288, 1.8877887436364356, 0.4759101999780686}, {0.3582668019998647, 1.8028028330189394, -1.686589110781385, 0.6510847792016188, -0.31030718387308553, -0.7489258012801323, 0.9015059571147588, 1.9104156847753782, -1.3784008495777664}, {-0.59937896776787, -1.0492282413629987, 0.20456776004450328, -1.945392820502514, -1.8290246077445729, 1.0789721555234801, 0.12413186682524868, 0.37942481889877744, 0.22302608172181682}, {-1.2694129021895963, 1.384402159792352, 1.3355962450306795, 1.0724617426145335, 1.7618370733455562, -0.781929919429452, -1.9379071463484805, -0.30883774126477537, -0.7733397713675831}}, {{}, {}, {}, {}, {}, {}, {}, {}, {}}};/*weights_end*/
/*biases_start*/double[][] biases = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-0.3403412939906989, 1.2747741956759575, -1.4452669177134987, -0.583229915058249, -0.14549818978066842, 1.3941735226741256, -1.808512162260996, -0.7361455428699966, 1.1640481489838508, -1.0191500072334239, -0.09531663073802932, 0.38394662303126825, 0.39499518948368006, 0.1649189054801914, -1.4627900128962184, 0.58026991938778}, {-1.2374560894453888, 0.2850885779362464, 0.49750639915504236, 0.8670343886492198, -1.3466071022432153, 1.4270374601718503, -0.7421241521015665, 0.6782487632299556, 0.9484369602725544, -1.7179053461426022, 1.303321985741285, 0.27590662058785753, 0.5279670703085406, 1.1860548982953016, -1.2008300477852636, -0.31979297175267574}, {-1.0355517752987056, 0.8793269288832599, 1.098408686691446, 1.2508202497173118, 1.5546807038835966, -1.8511355902226523, -0.15393416787832637, 1.8625599645749058, -0.9924576400060987}};/*biases_end*/

    void runFirstTurn() {
        communication.downloadAllyBase();
        communication.downloadMapBoundariesAndEnemyBase();

        if(weights.length != LAYER_SIZES.length)
            if(loggingOn) uc.println("ERROR 1");
        if(biases.length != LAYER_SIZES.length)
            if(loggingOn) uc.println("ERROR 2");
        for(int layer = 0; layer < LAYER_SIZES.length; layer++) {
            if(weights[layer].length != LAYER_SIZES[layer])
                if(loggingOn) uc.println("ERROR 3");
            if(biases[layer].length != LAYER_SIZES[layer])
                if(loggingOn) uc.println("ERROR 4");
        }
    }

    void run() {
//        communication.downloadMapBoundariesAndEnemyBase();
//        communication.lookForMapBoundaries();

        communication.addAllyAlive();

        UnitInfo nearestEnemyOrNeutral = getNearestEnemyOrNeutral(false, true);

        if(nearestEnemyOrNeutral != null) {
            if(loggingOn) uc.println("nearestEnemyOrNeutral " + nearestEnemyOrNeutral.getLocation());
            int damage = tryAttack(nearestEnemyOrNeutral.getLocation());
            if(damage != 0)
                communication.addScore(damage);
        }

        if(uc.canMove()) {
            if(loggingOn) uc.println("start (" + uc.getEnergyUsed() + " energy)");
            double[] inputData = getInputData(nearestEnemyOrNeutral);
            if(loggingOn) uc.println("inputData " + Arrays.toString(inputData) + " (" + uc.getEnergyUsed() + " energy)");
            double[] outputs = forwardPropagate(inputData);
            if(loggingOn) uc.println("outputs " + Arrays.toString(outputs) + " (" + uc.getEnergyUsed() + " energy)");
            Direction outputDirection = getDirectionFromOutputs(outputs);
            if(loggingOn) uc.println("outputDirection " + outputDirection + " (" + uc.getEnergyUsed() + " energy)");
            tryMove(outputDirection);
        }
    }

    double[] getInputData(UnitInfo nearestEnemyOrNeutral) {
        Location selfLocation = uc.getLocation();

        int canMoveDirectionNorth = uc.canMove(Direction.NORTH) ? 1 : 0;
        int canMoveDirectionNorthEast = uc.canMove(Direction.NORTHEAST) ? 1 : 0;
        int canMoveDirectionEast = uc.canMove(Direction.EAST) ? 1 : 0;
        int canMoveDirectionSouthEast = uc.canMove(Direction.SOUTHEAST) ? 1 : 0;
        int canMoveDirectionSouth = uc.canMove(Direction.SOUTH) ? 1 : 0;
        int canMoveDirectionSouthWest = uc.canMove(Direction.SOUTHWEST) ? 1 : 0;
        int canMoveDirectionWest = uc.canMove(Direction.WEST) ? 1 : 0;
        int canMoveDirectionNorthWest = uc.canMove(Direction.NORTHWEST) ? 1 : 0;

        double selfHealth = Math.log(uc.getInfo().getHealth());

//        double allyBaseDistance = Math.log(Math.sqrt(selfLocation.distanceSquared(communication.allyBaseLocation)));

        int nearestEnemyOrNeutralExists = 0;

        int nearestEnemyOrNeutralDirectionNorth = 0;
        int nearestEnemyOrNeutralDirectionNorthEast = 0;
        int nearestEnemyOrNeutralDirectionEast = 0;
        int nearestEnemyOrNeutralDirectionSouthEast = 0;
        int nearestEnemyOrNeutralDirectionSouth = 0;
        int nearestEnemyOrNeutralDirectionSouthWest = 0;
        int nearestEnemyOrNeutralDirectionWest = 0;
        int nearestEnemyOrNeutralDirectionNorthWest = 0;

        double nearestEnemyOrNeutralHealth = 0;
        double nearestEnemyOrNeutralAttackDamage = 0;

        int nearestEnemyOrNeutralSelfCloseEnoughToAttack = 0;
        int nearestEnemyOrNeutralCanSeeSelf = 0;
        int nearestEnemyOrNeutralCloseEnoughToAttackSelf = 0;

        int nearestEnemyOrNeutralCanMoveNextTurn = 0;
        int nearestEnemyOrNeutralCanAttackNextTurn = 0;

        if(nearestEnemyOrNeutral != null) {
            Location nearestEnemyOrNeutralLocation = nearestEnemyOrNeutral.getLocation();
            int distanceToNearestEnemyOrNeutral = selfLocation.distanceSquared(nearestEnemyOrNeutralLocation);
            UnitType nearestEnemyOrNeutralType = nearestEnemyOrNeutral.getType();

            nearestEnemyOrNeutralExists = 1;

            int nearestEnemyOrNeutralRelativeLocationX = nearestEnemyOrNeutralLocation.x - selfLocation.x;
            int nearestEnemyOrNeutralRelativeLocationY = nearestEnemyOrNeutralLocation.y - selfLocation.y;
            if(nearestEnemyOrNeutralRelativeLocationX == 0) {
                if(nearestEnemyOrNeutralRelativeLocationY > 0)
                    nearestEnemyOrNeutralDirectionNorth = 1;
                else
                    nearestEnemyOrNeutralDirectionSouth = 1;
            }
            else if(nearestEnemyOrNeutralRelativeLocationY == 0) {
                if(nearestEnemyOrNeutralRelativeLocationX > 0)
                    nearestEnemyOrNeutralDirectionEast = 1;
                else
                    nearestEnemyOrNeutralDirectionWest = 1;
            }
            else {
                if(nearestEnemyOrNeutralRelativeLocationX > 0 && nearestEnemyOrNeutralRelativeLocationY > 0)
                    nearestEnemyOrNeutralDirectionNorthEast = 1;
                else if(nearestEnemyOrNeutralRelativeLocationX > 0)
                    nearestEnemyOrNeutralDirectionSouthEast = 1;
                else if(nearestEnemyOrNeutralRelativeLocationY < 0)
                    nearestEnemyOrNeutralDirectionSouthWest = 1;
                else
                    nearestEnemyOrNeutralDirectionNorthWest = 1;
            }

            nearestEnemyOrNeutralHealth = Math.log(nearestEnemyOrNeutral.getHealth());
            nearestEnemyOrNeutralAttackDamage = Math.log(nearestEnemyOrNeutralType.getStat(UnitStat.ATTACK));

            if(distanceToNearestEnemyOrNeutral <= selfAttackRange && distanceToNearestEnemyOrNeutral >= selfMinAttackRange)
                nearestEnemyOrNeutralSelfCloseEnoughToAttack = 1;

            float nearestEnemyOrNeutralVisionRange = nearestEnemyOrNeutralType.getStat(UnitStat.VISION_RANGE);
            if(distanceToNearestEnemyOrNeutral <= nearestEnemyOrNeutralVisionRange)
                nearestEnemyOrNeutralCanSeeSelf = 1;

            float nearestEnemyOrNeutralAttackRange = nearestEnemyOrNeutralType.getStat(UnitStat.ATTACK_RANGE);
            float nearestEnemyOrNeutralMinAttackRange = nearestEnemyOrNeutralType.getStat(UnitStat.MIN_ATTACK_RANGE);
            if(distanceToNearestEnemyOrNeutral <= nearestEnemyOrNeutralAttackRange && distanceToNearestEnemyOrNeutral >= nearestEnemyOrNeutralMinAttackRange)
                nearestEnemyOrNeutralCloseEnoughToAttackSelf = 1;

            float nearestEnemyOrNeutralMoveCooldown = nearestEnemyOrNeutral.getCurrentMovementCooldown();
            if(nearestEnemyOrNeutralMoveCooldown <= 1)
                nearestEnemyOrNeutralCanMoveNextTurn = 1;

            float nearestEnemyOrNeutralAttackCooldown = nearestEnemyOrNeutral.getCurrentAttackCooldown();
            if(nearestEnemyOrNeutralAttackCooldown <= 1)
                nearestEnemyOrNeutralCanAttackNextTurn = 1;
        }

        return new double[]{
                canMoveDirectionNorth, canMoveDirectionNorthEast,
                canMoveDirectionEast, canMoveDirectionSouthEast,
                canMoveDirectionSouth, canMoveDirectionSouthWest,
                canMoveDirectionWest, canMoveDirectionNorthWest,
                selfHealth, nearestEnemyOrNeutralExists,
                nearestEnemyOrNeutralDirectionNorth, nearestEnemyOrNeutralDirectionNorthEast,
                nearestEnemyOrNeutralDirectionEast, nearestEnemyOrNeutralDirectionSouthEast,
                nearestEnemyOrNeutralDirectionSouth, nearestEnemyOrNeutralDirectionSouthWest,
                nearestEnemyOrNeutralDirectionWest, nearestEnemyOrNeutralDirectionNorthWest,
                nearestEnemyOrNeutralHealth, nearestEnemyOrNeutralAttackDamage,
                nearestEnemyOrNeutralSelfCloseEnoughToAttack, nearestEnemyOrNeutralCanSeeSelf,
                nearestEnemyOrNeutralCloseEnoughToAttackSelf,
                nearestEnemyOrNeutralCanMoveNextTurn, nearestEnemyOrNeutralCanAttackNextTurn
        };
    }

    double relu(double x) {
        if(x > 0)
            return x;
        return 0;
    }

    double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    double[] forwardPropagate(double[] inputData) {
        double[][] activations = new double[LAYER_SIZES.length][];
        for(int layer = 1; layer < LAYER_SIZES.length; layer++) {
            activations[layer] = new double[LAYER_SIZES[layer]];
            for(int neuron = 0; neuron < activations[layer].length; neuron++) {
                activations[layer][neuron] = 0;
                if(layer == 1) {
                    for(int previousNeuron = 0; previousNeuron < inputData.length; previousNeuron++) {
                        activations[layer][neuron] += inputData[previousNeuron] * weights[layer - 1][previousNeuron][neuron];
                    }
                }
                else {
                    for(int previousNeuron = 0; previousNeuron < activations[layer - 1].length; previousNeuron++) {
                        activations[layer][neuron] += activations[layer - 1][previousNeuron] * weights[layer - 1][previousNeuron][neuron];
                    }
                }

                activations[layer][neuron] += biases[layer][neuron];

                if(layer != LAYER_SIZES.length - 1)
                    activations[layer][neuron] = relu(activations[layer][neuron]);
                else
                    activations[layer][neuron] = sigmoid(activations[layer][neuron]);
            }
        }

        int outputLayer = LAYER_SIZES.length - 1;
        double[] outputs = new double[LAYER_SIZES[outputLayer]];
        System.arraycopy(activations[outputLayer], 0, outputs, 0, activations[outputLayer].length);
        return outputs;
    }

    Direction getDirectionFromOutputs(double[] outputs) {
//        double highestOutput = 0;
//        int highestOutputIndex = 0;
//        for(int i = 0; i < outputs.length; i++) {
//            if(outputs[i] > highestOutput) {
//                highestOutput = outputs[i];
//                highestOutputIndex = i;
//            }
//        }
//        return directions[highestOutputIndex];
        double totalOutputs = 0;
        for (double output : outputs) {
            totalOutputs += output;
        }
        double selectRandomPercent = Math.random();
        int selectIndex = 0;
        double currentPercent = 0;
        for(int i = 0; i < outputs.length; i++) {
            currentPercent += outputs[i] / totalOutputs;
            if(currentPercent >= selectRandomPercent) {
                selectIndex = i;
                break;
            }
        }
        return directions[selectIndex];
    }
}