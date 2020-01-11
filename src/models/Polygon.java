package models;

import java.util.ArrayList;
import java.util.Collections;

public class Polygon {
    public static double PI = 3.14159265;
    public static double TWOPI = 2 * PI;

    public String Coordinate_city(double lat1, double lat2) {
        ArrayList<Double> lat_array_Almaty = new ArrayList<Double>();
        ArrayList<Double> long_array_Almaty = new ArrayList<Double>();

        ArrayList<Double> lat_array_Astana = new ArrayList<Double>();
        ArrayList<Double> long_array_Astana = new ArrayList<Double>();

        ArrayList<Double> lat_array_Aktobe = new ArrayList<Double>();
        ArrayList<Double> long_array_Aktobe = new ArrayList<Double>();

        ArrayList<Double> lat_array_Atyrau = new ArrayList<Double>();
        ArrayList<Double> long_array_Atyrau = new ArrayList<Double>();

        ArrayList<Double> lat_array_VKO = new ArrayList<Double>();
        ArrayList<Double> long_array_VKO = new ArrayList<Double>();

        ArrayList<Double> lat_array_Zhamb = new ArrayList<Double>();
        ArrayList<Double> long_array_Zhamb = new ArrayList<Double>();

        ArrayList<Double> lat_array_ZKO = new ArrayList<Double>();
        ArrayList<Double> long_array_ZKO = new ArrayList<Double>();

        ArrayList<Double> lat_array_Karaganda_42 = new ArrayList<Double>();
        ArrayList<Double> long_array_Karaganda_42 = new ArrayList<Double>();

        ArrayList<Double> lat_array_Karaganda_43 = new ArrayList<Double>();
        ArrayList<Double> long_array_Karaganda_43 = new ArrayList<Double>();

        ArrayList<Double> lat_array_Kostanay = new ArrayList<Double>();
        ArrayList<Double> long_array_Kostanay = new ArrayList<Double>();

        ArrayList<Double> lat_array_Kyzylorda = new ArrayList<Double>();
        ArrayList<Double> long_array_Kyzylorda = new ArrayList<Double>();

        ArrayList<Double> lat_array_Mangystau = new ArrayList<Double>();
        ArrayList<Double> long_array_Mangystau = new ArrayList<Double>();


        ArrayList<Double> lat_array_Pavlodar = new ArrayList<Double>();
        ArrayList<Double> long_array_Pavlodar = new ArrayList<Double>();


        ArrayList<Double> lat_array_SKO = new ArrayList<Double>();
        ArrayList<Double> long_array_SKO = new ArrayList<Double>();

        ArrayList<Double> lat_array_Turkestan = new ArrayList<Double>();
        ArrayList<Double> long_array_Turkestan = new ArrayList<Double>();

        ArrayList<String> polygon_Almaty = new ArrayList<String>();
        Collections.addAll(polygon_Almaty, "45.800734, 73.898918", "46.677375, 75.327141", "46.692496, 77.370598", "47.237726, 77.481081", "46.499339, 81.589968",
                "45.364827, 82.578737", "45.147561, 82.402956", "44.898232, 80.425417", "43.170589, 80.798952", "42.279603, 80.293581", "42.864251, 78.447878",
                "42.864251, 76.360476", "43.090123, 75.349733", "43.631199, 74.965212", "44.902136, 74.086306", "45.946500, 73.833620");

        ArrayList<String> polygon_Astana = new ArrayList<String>();
        Collections.addAll(polygon_Astana, "53.412937, 70.659278", "53.205665, 71.702979", "52.975687, 72.817168",
                "52.485496, 73.954253", "51.543267, 74.212432", "50.880837, 72.959991", "50.454930, 71.773467", "50.067580, 70.147491", "50.237038, 68.754578",
                "50.609026, 68.835603", "50.633488, 68.118745", "50.407678, 67.143779", "50.847927, 65.622172", "51.743313, 65.377727", "52.201319, 66.006694",
                "52.238431, 67.047648", "52.537555, 68.017192", "52.949884, 68.637747", "53.452880, 68.497671", "53.603441, 69.152731", "53.506129, 69.424643");


        ArrayList<String> polygon_Aktobe = new ArrayList<String>();
        Collections.addAll(polygon_Aktobe, "50.997509,54.587305", "50.607641,55.707910", "51.135956,56.740625", "51.191218,58.344629",
                "50.593657,59.860742", "50.900349,60.025537", "50.837781,61.409815", "51.356606,61.739405", "50.002534,62.925928", "49.267602,62.541407",
                "47.949013,64.266260", "47.190650,62.794092", "47.867760,61.970117", "47.823386,61.310938", "47.138200,60.915430", "47.138200,60.497950",
                "46.950454,60.459497", "46.886468,60.124414", "46.013222,59.036768", "45.358718,59.064234", "45.607370,58.601702", "45.247651,56.755999",
                "46.515980,56.296260", "46.833585,55.307490", "47.236258,54.901895", "48.697017,54.857949", "48.791473,54.671182", "48.653362,54.517373",
                "48.762429,54.033975", "49.181919,53.984536", "49.169314,53.907632", "49.108043,53.881539", "49.125171,53.827981", "49.152202,53.830728",
                "49.200558,53.662315", "49.244633,53.629356", "49.307530,53.627983", "49.470430,53.683061", "49.490115,53.619890", "49.543225,53.616302",
                "49.511939,53.689086", "49.529819,53.735778", "49.586993,53.739898", "49.609308,53.820922", "49.608416,54.037216", "49.580743,54.254196",
                "49.632505,54.346206", "49.668052,54.314620", "49.736636,54.402511", "49.747315,54.500015", "49.824671,54.465683", "50.029410,54.564559",
                "50.099246,54.465683", "50.103663,54.428604", "50.298466,54.409378", "50.322211,54.355133", "50.532751,54.537780", "50.564251,54.589965",
                "50.541503,54.614685", "50.621946,54.716308", "50.691478,54.717850", "50.719384,54.676651", "50.819534,54.658799", "50.836060,54.679398",
                "50.894288,54.695877", "50.923808,54.613480", "50.913391,54.564041", "50.934223,54.540009", "50.972928,54.570140", "50.987666,54.561214",
                "51.000666,54.547481");

        ArrayList<String> polygon_Atyrau = new ArrayList<String>();
        Collections.addAll(polygon_Atyrau, "47.705992,47.353136", "48.281186,47.122423", "47.964890,49.451525", "48.697445,51.033556",
                "48.690172,51.802599", "48.591881,51.758654", "48.577303,51.797106", "48.584592,52.123949", "48.533543,52.519457", "49.026960,52.793713",
                "49.063070,53.397961", "49.265231,53.618282", "49.157266,54.002803", "48.795667,54.024776", "48.650288,54.541133", "48.802925,54.650996",
                "48.715761,54.909175", "47.191925,54.997066", "46.755778,55.392574", "46.528779,56.304439", "46.155952,56.458247", "46.247493,55.837520",
                "46.402992,55.827393", "46.429587,55.602174", "46.520668,55.492310", "46.368780,55.278077", "46.258395,53.987183", "46.017821,53.679566",
                "45.948891,53.745484", "45.801167,53.292298", "45.817494,53.179688", "45.754082,53.120637", "45.958470,52.604279", "46.387790,52.884431",
                "46.734484,52.623505", "46.719374,51.629243", "46.904639,50.940615", "46.511659,49.984804", "46.184519,49.830995", "46.678271,48.512636",
                "46.784029,48.996034", "47.770923,48.062197", "47.704223,47.370058", "47.957561,46.980471", "48.220703,47.098574");

        ArrayList<String> polygon_VKO = new ArrayList<String>();
        Collections.addAll(polygon_VKO, "47.255719, 76.810288", "47.414426, 76.889939", "47.403239, 77.065720", "47.577765, 77.035164",
                "47.861338, 77.057137", "47.866883, 77.135415", "47.950905, 77.142968", "47.967508, 77.200646", "48.026730, 77.185540", "48.073690, 77.333855",
                "48.108651, 77.284417", "48.113250, 77.158074", "48.184932, 77.064690", "48.246424, 77.057137", "48.242755, 77.145714", "48.281039, 77.150349",
                "48.294099, 76.980919", "48.402117, 76.827111", "48.422231, 76.894402", "48.486175, 76.902642", "48.506650, 76.955072", "48.495698, 77.001249",
                "48.493416, 77.160551", "48.628420, 77.306129", "48.747079, 77.329475", "48.853223, 77.288962", "48.821330, 76.991407", "48.794458, 76.907636",
                "48.844057, 76.858385", "48.864107, 76.849802", "48.905089, 76.871431", "49.012844, 76.849974", "49.046707, 76.986617", "49.073556, 77.019576",
                "49.133518, 76.923445", "49.150637, 76.828688", "49.248279, 76.767577", "49.330472, 76.640204", "49.428204, 76.564673", "49.481919, 76.600379",
                "49.532042, 76.771867", "49.523550, 76.823366", "49.586535, 77.030816", "49.714486, 77.177072", "49.752761, 77.181878", "49.788561, 77.141709",
                "49.889146, 77.148233", "49.948779, 77.204713", "49.941247, 77.228059", "50.011600, 77.452088", "50.165591, 77.686921", "50.194716, 77.711697",
                "50.217852, 77.697277", "50.234026, 77.756665", "50.189112, 77.795632", "50.033287, 78.406763", "50.066889, 78.537912", "50.114157, 78.628550",
                "50.273726, 78.750086", "50.311116, 78.792315", "50.441091, 78.760386", "50.460381, 78.682795", "50.625774, 78.691721", "50.695164, 78.692788",
                "50.744857, 78.615197", "50.743550, 78.566445", "50.738321, 78.537263", "50.826953, 78.461670", "50.870640, 78.344941", "50.879111, 78.279366",
                "50.928390, 78.246750", "50.948510, 78.215336", "51.005839, 78.205380", "51.040700, 78.114743", "51.102994, 78.136372", "51.118014, 78.132252",
                "51.127305, 78.120579", "51.132382, 78.106846", "51.134394, 78.086633", "51.189442, 78.268937", "51.211209, 78.320281", "51.240742, 78.336074",
                "51.208837, 78.399589", "51.221774, 78.517692", "51.297601, 78.790659", "51.381466, 78.793405", "51.384474, 78.745340", "51.446892, 78.741209",
                "51.458530, 78.896034", "51.443943, 78.984883", "51.524969, 79.107106", "51.574628, 79.070027", "51.640470, 79.249928", "51.672928, 79.231010",
                "51.698750, 79.259849", "51.708563, 79.344649", "50.734164, 80.081686", "50.827324, 80.066580", "50.825792, 80.185188", "50.897062, 80.196861",
                "50.897496, 80.294364", "50.725076, 80.129532", "50.956371, 80.486588", "51.201007, 80.484267", "51.192379, 80.636702", "51.309587, 80.680647",
                "51.156121, 81.155806", "50.950121, 81.048689", "50.969646, 81.406310", "50.756713, 81.442016", "50.724471, 82.559875", "50.984506, 83.389867",
                "50.946349, 83.480504", "50.777529, 83.931766", "50.206352, 84.327274", "50.045263, 85.000485", "49.903557, 84.975765", "49.588539, 85.247677",
                "49.465625, 86.201427", "49.579499, 86.286400", "49.586642, 86.379784", "49.743524, 86.617363", "49.803557, 86.599510", "49.795113, 86.711433",
                "49.786667, 86.771172", "49.742634, 86.747826", "49.742634, 86.747826", "49.742634, 86.747826", "49.568559, 86.616386", "49.543381, 86.815900",
                "49.500244, 86.849545", "49.484813, 86.824826", "49.484813, 86.824826", "49.484813, 86.824826", "49.361625, 86.920523", "49.255670, 87.018026",
                "49.229595, 87.299551", "49.124255, 87.270712", "49.156691, 87.130636", "49.111635, 86.961721", "49.118847, 86.855978", "49.057585, 86.828221",
                "49.008825, 86.707372", "48.922926, 86.718358", "48.832346, 86.796636", "48.672524, 86.638707", "48.519489, 86.309117", "48.468374, 85.781774",
                "48.333361, 85.673179", "48.306799, 85.636101", "47.953774, 85.504265", "47.232910, 85.559196", "47.071777, 85.218620", "46.932735, 84.801140",
                "47.030478, 84.680290", "47.017331, 84.048576", "47.253485, 83.035087", "45.620636, 82.216606", "46.930853, 80.019340", "46.840465, 79.519462",
                "47.103668, 79.173393", "47.088663, 78.695488", "47.287135, 78.267021", "47.212327, 78.074760", "47.279659, 77.893486", "47.208584, 77.228813");


        ArrayList<String> polygon_Zhamb = new ArrayList<String>();
        Collections.addAll(polygon_Zhamb, "45.986261,69.125885", "45.982432,74.020294", "45.304308,73.740143", "45.086808,73.745636",
                "44.922155,74.120934", "43.697552,75.001474", "43.562888,75.235620", "43.041346,75.632502", "42.805182,75.713526", "43.006080,74.846979",
                "42.9899654, 74.7497679",
                "43.268068,74.211832", "43.179416,74.045168", "43.130653,73.822694", "42.437059,73.457365", "42.802691,71.553297", "42.683756,71.185255",
                "42.606705,71.125517", "42.329138,70.867339", "42.754638,70.227385", "43.212885,69.927321", "43.659714,69.612151", "44.939791,69.650603");


        ArrayList<String> polygon_ZKO = new ArrayList<String>();
        Collections.addAll(polygon_ZKO, "51.793707, 50.808073", "51.759632, 52.357145",
                "51.465514, 53.521696", "50.857615, 54.499479",
                "49.760113, 54.554411", "49.560424, 54.356657", "49.445947, 53.708464", "49.244962, 53.631559",
                "49.043151, 53.488737", "49.021480, 52.862516",
                "48.476601, 52.686735", "48.549595, 50.950895", "48.080604, 49.995085", "47.903614, 49.456755",
                "48.407159, 46.435514", "49.863199, 46.852995",
                "50.494610, 47.556120", "51.134931, 49.401823", "51.848174, 50.753141");


        ArrayList<String> polygon_Karaganda_43 = new ArrayList<String>();
        Collections.addAll(polygon_Karaganda_43, "50.479917,72.045203", "50.904293,72.728150",
                "51.118441,73.882549",
                "50.042465,74.924308", "50.379746,77.193467", "48.592851,76.940844", "46.488534,76.952416",
                "46.609313,75.004774", "45.927715,73.971493", "45.910526,73.301952", "46.025850,72.171505",
                "47.445412,72.021923",
                "48.707807,71.902927", "49.657767,71.884064");

        ArrayList<String> polygon_Karaganda_42 = new ArrayList<String>();
        Collections.addAll(polygon_Karaganda_42, "46.015037,71.853649", "45.965704,69.456409",
                "46.001211,67.101439", "46.186208,65.404913",
                "46.799553,63.749995", "47.147218,62.776663", "47.877969,64.132145", "48.865923,64.670930",
                "49.126237,66.368603", "50.088633,67.443538",
                "50.564932,68.077624", "50.669560,69.020467", "50.225399,68.892261", "50.268126,70.659415",
                "50.789552,71.286210", "50.756636,71.683140",
                "50.218018,71.741559", "49.157658,71.722935", "48.246130,71.856896", "47.121347,71.873531");

        ArrayList<String> polygon_Kostanay = new ArrayList<String>();
        Collections.addAll(polygon_Kostanay, "48.244174, 64.024935", "48.722562, 63.102083",
                "49.214413, 62.497835", "49.644352, 62.492342",
                "49.918235, 62.734041", "49.868554, 62.937288", "49.976722, 62.955141", "50.760189, 62.344027",
                "51.160430, 62.023156", "51.483970, 61.495813",
                "51.750699, 60.616906", "51.975164, 60.100549", "52.147844, 60.798181", "52.338364, 61.078332",
                "52.506280, 61.004174", "52.639315, 60.855859",
                "52.754120, 60.729516", "52.773280, 60.842126", "52.827797, 60.903237", "52.920028, 61.081765",
                "52.976433, 61.025460", "52.966485, 61.100991",
                "53.031936, 61.249307", "52.991351, 61.297372", "52.987208, 61.392129", "52.926668, 62.029336",
                "53.130339, 62.100747", "53.306732, 61.221841",
                "53.475841, 61.339944", "53.650804, 60.922464", "54.073730, 61.355737", "54.066460, 62.718728",
                "54.285593, 65.146707", "54.643981, 65.915750",
                "53.722540, 66.091531", "52.358634, 65.849832", "52.1037396, 65.7210538", "51.861460, 65.382913",
                "51.072354, 65.514749", "50.745893, 66.042092", "50.536309, 66.920999",
                "50.431164, 67.986673", "49.633515, 66.817601", "49.052072, 65.883764", "49.001499, 64.796117",
                "48.700613, 64.493993");

        ArrayList<String> polygon_Kyzylorda = new ArrayList<String>();
        Collections.addAll(polygon_Kyzylorda, "47.833475, 61.921799", "46.431584, 65.173752", "46.111602, 67.085373", "44.017565, 67.986252",
                "43.197320, 67.796738", "42.367855, 66.137802", "43.800151, 65.157497", "43.544971, 62.015407", "45.380062, 59.129210", "46.007530, 59.046812",
                "47.098876, 60.656309", "47.795680, 61.353941");

        ArrayList<String> polygon_Mangystau = new ArrayList<String>();
        Collections.addAll(polygon_Mangystau, "45.129933, 49.879247", "45.207648, 50.340672", "45.083253, 50.846044", "45.579196, 51.615087",
                "45.548328, 52.362157", "45.640882, 52.603856", "45.948286, 52.581883", "45.794797, 53.120213", "45.955949, 53.713475", "46.276842, 53.977147",
                "46.345360, 55.262547", "46.520070, 55.493260", "46.108990, 56.504003", "45.192114, 56.745702", "45.013160, 55.998631", "41.367696, 55.957817",
                "41.251723, 55.584282", "42.345063, 54.145073", "41.747285, 52.409233", "42.050976, 52.266411", "44.875018, 49.794487", "45.124449, 49.926323");

        ArrayList<String> polygon_Pavlodar = new ArrayList<String>();
        Collections.addAll(polygon_Pavlodar, "53.792073, 74.987164", "53.465550, 73.251325", "52.884689, 73.580914", "51.753720, 73.734723",
                "51.273881, 73.657819", "50.621514, 73.954450", "49.988261, 74.910260", "50.246102, 76.629620", "50.030742, 78.387433", "50.312093, 78.807880",
                "50.742781, 78.700764", "51.124607, 78.143207", "51.633372, 79.398395", "53.304156, 77.975205", "54.485071, 76.942490", "54.109145, 75.382432",
                "53.845241, 74.967698");

        ArrayList<String> polygon_SKO = new ArrayList<String>();
        Collections.addAll(polygon_SKO, "54.670418, 66.035352", "55.012802, 67.837110",
                "55.214321, 68.150220", "55.474149, 68.886304",
                "55.386687, 69.743237", "55.320963, 70.797925", "54.370037, 72.253613", "54.074624, 73.800618",
                "53.193155, 73.800618", "52.835371, 74.097249",
                "52.555031, 73.932454", "52.648679, 72.921712", "52.928417, 71.685750", "53.206349, 70.263020",
                "53.480234, 69.311942", "53.549661, 68.802247",
                "53.062707, 68.807740", "52.783841, 68.725343", "52.603615, 68.362794", "52.449500, 68.055177",
                "52.234173, 67.857423", "52.176800, 67.297120",
                "52.352060, 65.890870", "53.079249, 65.945802", "53.995462, 65.901856", "54.637754, 66.052918");

        ArrayList<String> polygon_Tukestan = new ArrayList<String>();
        Collections.addAll(polygon_Tukestan, "45.989186, 67.243147", "45.977698, 69.050398",
                "44.037358, 69.693098",
                "43.233454, 69.761762",
                "42.648265, 70.404463", "42.243465, 70.887861", "41.790828, 70.030927", "41.474530, 69.436292",
                "41.364957, 69.090910", "41.277993, 69.014005",
                "41.137206, 68.837881", "40.971183, 68.718597", "41.008078, 68.501768", "40.818994, 68.558073",
                "40.580171, 68.486662", "40.82144, 67.93292", "41.024720, 68.015623",
                "41.212693, 67.353697", "41.262451, 66.614866", "41.899674, 66.543455", "42.329120, 66.147947",
                "43.201314, 67.872801", "43.745377, 67.977171",
                "44.390952, 67.532224", "45.303722, 67.206704");

        ArrayList<ArrayList> polygons = new ArrayList<>();
        Collections.addAll(polygons, polygon_Almaty, polygon_Astana, polygon_Aktobe, polygon_Atyrau, polygon_VKO, polygon_Zhamb, polygon_ZKO, polygon_Karaganda_42,
                polygon_Karaganda_43, polygon_Kostanay, polygon_Kyzylorda, polygon_Mangystau, polygon_Pavlodar, polygon_SKO, polygon_Tukestan);

        for (ArrayList p : polygons) {
            for (String s : polygon_Almaty) {
                lat_array_Almaty.add(Double.parseDouble(s.split(",")[0]));
                long_array_Almaty.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Astana) {
                lat_array_Astana.add(Double.parseDouble(s.split(",")[0]));
                long_array_Astana.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Aktobe) {
                lat_array_Aktobe.add(Double.parseDouble(s.split(",")[0]));
                long_array_Aktobe.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Atyrau) {
                lat_array_Atyrau.add(Double.parseDouble(s.split(",")[0]));
                long_array_Atyrau.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_VKO) {
                lat_array_VKO.add(Double.parseDouble(s.split(",")[0]));
                long_array_VKO.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Zhamb) {
                lat_array_Zhamb.add(Double.parseDouble(s.split(",")[0]));
                long_array_Zhamb.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_ZKO) {
                lat_array_ZKO.add(Double.parseDouble(s.split(",")[0]));
                long_array_ZKO.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Karaganda_43) {
                lat_array_Karaganda_43.add(Double.parseDouble(s.split(",")[0]));
                long_array_Karaganda_43.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Kostanay) {
                lat_array_Kostanay.add(Double.parseDouble(s.split(",")[0]));
                long_array_Kostanay.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Kyzylorda) {
                lat_array_Kyzylorda.add(Double.parseDouble(s.split(",")[0]));
                long_array_Kyzylorda.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Mangystau) {
                lat_array_Mangystau.add(Double.parseDouble(s.split(",")[0]));
                long_array_Mangystau.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Pavlodar) {
                lat_array_Pavlodar.add(Double.parseDouble(s.split(",")[0]));
                long_array_Pavlodar.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_SKO) {
                lat_array_SKO.add(Double.parseDouble(s.split(",")[0]));
                long_array_SKO.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Tukestan) {
                lat_array_Turkestan.add(Double.parseDouble(s.split(",")[0]));
                long_array_Turkestan.add(Double.parseDouble(s.split(",")[1]));
            }
            for (String s : polygon_Karaganda_42) {
                lat_array_Karaganda_42.add(Double.parseDouble(s.split(",")[0]));
                long_array_Karaganda_42.add(Double.parseDouble(s.split(",")[1]));
            }

        }


        if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Almaty, long_array_Almaty))
            return "Almaty";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Astana, long_array_Astana))
            return "Astana";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Aktobe, long_array_Aktobe))
            return "Aktobe";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Atyrau, long_array_Atyrau))
            return "Atyrau";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_VKO, long_array_VKO))
            return "VKO";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Zhamb, long_array_Zhamb))
            return "Zhamb";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_ZKO, long_array_ZKO))
            return "ZKO";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Karaganda_43, long_array_Karaganda_43))
            return "Karaganda_43";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Karaganda_42, long_array_Karaganda_42))
            return "Karaganda_42";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Kostanay, long_array_Kostanay))
            return "Kostanay";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Kyzylorda, long_array_Kyzylorda))
            return "Kyzylorda";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Mangystau, long_array_Mangystau))
            return "Mangystau";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Pavlodar, long_array_Pavlodar))
            return "Pavlodar";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_SKO, long_array_SKO))
            return "SKO";
        else if (coordinate_is_inside_polygon(
                lat1, lat2,
                lat_array_Turkestan, long_array_Turkestan))
            return "Turkestan";


        else return "outside";
    }


    public static boolean coordinate_is_inside_polygon(
            double latitude, double longitude,
            ArrayList<Double> lat_array, ArrayList<Double> long_array) {
        int i;
        double angle = 0;
        double point1_lat;
        double point1_long;
        double point2_lat;
        double point2_long;
        int n = lat_array.size();

        for (i = 0; i < n; i++) {
            point1_lat = lat_array.get(i) - latitude;
            point1_long = long_array.get(i) - longitude;
            point2_lat = lat_array.get((i + 1) % n) - latitude;
            //you should have paid more attention in high school geometry.
            point2_long = long_array.get((i + 1) % n) - longitude;
            angle += Angle2D(point1_lat, point1_long, point2_lat, point2_long);
        }

        if (Math.abs(angle) < PI)
            return false;
        else
            return true;
    }

    public static double Angle2D(double y1, double x1, double y2, double x2) {
        double dtheta, theta1, theta2;

        theta1 = Math.atan2(y1, x1);
        theta2 = Math.atan2(y2, x2);
        dtheta = theta2 - theta1;
        while (dtheta > PI)
            dtheta -= TWOPI;
        while (dtheta < -PI)
            dtheta += TWOPI;

        return (dtheta);
    }

    public static boolean is_valid_gps_coordinate(double latitude,
                                                  double longitude) {
        if (latitude > -90 && latitude < 90 &&
                longitude > -180 && longitude < 180) {
            return true;
        }
        return false;
    }
}
