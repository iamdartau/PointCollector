package Servlets;////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package Servlets;
//
//import Repositories.Db_command;
//import Repositories.UserRep;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import models.*;
//import org.apache.commons.lang3.time.DateUtils;
//
//@WebServlet({"/Calculations"})
//public class CalculationServlet extends HttpServlet {
//    public CalculationServlet() {
//    }
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        String answer = "";
//        String solution_type = "";
//        String bts_name = "";
//        Polygon polygon = new Polygon();
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
//        int id = Integer.parseInt(req.getParameter("id"));
//        String type = req.getParameter("type");
//        String request = req.getParameter("req_num");
//        String phone_number = req.getParameter("phone_numb");
//        String LatLon = req.getParameter("LatLon");
//        Pattern pattern = Pattern.compile("\\d{2}.\\d*");
//        Matcher matcher = pattern.matcher(LatLon);
//        ArrayList listMatcher = new ArrayList();
//
//        while (matcher.find()) {
//            listMatcher.add(matcher.group(0));
//        }
//
//        String lat = (String) listMatcher.get(0);
//        String lon = (String) listMatcher.get(1);
//        double latitude = Double.parseDouble(lat);
//        double longitude = Double.parseDouble(lon);
//        if (polygon.Coordinate_city(latitude, longitude).equals("outside")) {
//            resp.sendRedirect("/404.html");
//        } else {
//            Connection connection = Atoll_db.CheckDb(polygon.Coordinate_city(latitude, longitude));
//            Distance point1 = new Distance(latitude, longitude);
//            Db_command command = new Db_command();
//            Checker checker = new Checker();
//            int radius = 1000;
//            int month = 0;
//            Set<String> BTS_setG = command.getNearBS(point1, connection, "g", radius);
//            Set<String> BTS_setU = command.getNearBS(point1, connection, "u", radius);
//            Set<String> BTS_setL = command.getNearBS(point1, connection, "l", radius);
//            Set<String> BTS_GUL = new HashSet();
//            BTS_GUL.addAll(BTS_setG);
//            BTS_GUL.addAll(BTS_setU);
//            BTS_GUL.addAll(BTS_setL);
//            Transport_detail transport_detail = command.getTransDetail(BTS_GUL);
//            MocnOptimization mocnOptimization = command.getMocnOptimization(BTS_GUL);
//            Alarms alarms = checker.CheckForAlarms(BTS_GUL);
//            ArrayList<String> TransportNear = command.getTransport();
//            String transport = checker.CheckForTransmission(TransportNear, BTS_GUL);
//            ArrayList<String> DismantledNear = command.getNearSolutions("dismantled", latitude, longitude);
//            String dismantled = checker.CheckForDismantled(DismantledNear);
//            Set<Cell> Cell_setG = command.getNearCellsGsm(BTS_setG, connection);
//            Set<Cell> CellServedG = checker.GetServedList(Cell_setG, connection, latitude, longitude);
//            Set<Cell> Cell_setU = command.getNearCells(BTS_setU, connection, "u");
//            Set<Cell> CellServedU = checker.GetServedList(Cell_setU, connection, latitude, longitude);
//            Set<Cell> Cell_setL = command.getNearCells(BTS_setL, connection, "l");
//            Set<Cell> CellServedL = checker.GetServedList(Cell_setL, connection, latitude, longitude);
//            String interferedU = command.checkCell(CellServedU, "interference", "u");
//            String interferedG = command.checkCell(CellServedG, "interference", "g");
//            String interferedL = command.checkCell(CellServedL, "interference", "l");
//            String aut3G = command.checkCell(CellServedU, "aut", "u");
//            String aut4G = command.checkCell(CellServedL, "aut", "l");
//            String gu_upgrade = command.checkHardware(CellServedG, "gu_upgrade");
//            String lte_upgrade = command.checkHardware(CellServedU, "lte_upgrade");
//            String dualbeam = command.checkHardware(CellServedL, "dualbeam");
//            String rru_900 = command.checkHardware(CellServedU, "rru_900");
//            String rru_1800 = command.checkHardware(CellServedL, "rru_1800");
//            String rru_2100 = command.checkHardware(CellServedU, "rru_2100");
//            ArrayList<String> plannedBS = command.getNearSolutions("plan", latitude, longitude);
//            String planned_bs = checker.CheckForBsPlanned(plannedBS);
//            String alarms_answer = "На базовой станции, к которой подключается ваш номер, произошел кратковременный технический сбой  (отключился свет, погодные условия и другие внешние факторы). Наши специалисты уже работают над исправлением ситуации.";
//            String dismantled_answer = "Базовая станция, к которой был подключен ваш номер, была демонтирована. Для улучшения качества связи будет установлена новая базовая станция. Сроки выполнения работ:";
//            String optimization_answer = "Рядом с указанными координатами ведутся оптимизационные работы. Ожидаемые сроки:";
//            String aut_answer = "На базовой станции ведутся работы по распределению нагрузки в связи с тем, что растет количество абонентов. Сроки завершения работ:";
//            String no_answer = "Недостаточно данных для ответа. Проблему необходимо передать в соответствующий отдел для дополнительного анализа.";
//            String transport_answer = "На базовой станции, к которой подключается ваш номер, ведутся работы по распределению нагрузки в связи с тем, что растет количество абонентов. Ожидаемые сроки выполнения работ: ";
//            String rru_2100_answer = "На базовой станции, к которой подключается ваш номер, ведутся работы по улучшению качества связи 3G. Сроки выполнения работ: ";
//            String rru_900_answer = "На базовой станции, к которой подключается ваш номер, ведутся работы по улучшению качества связи 3G. Сроки выполнения работ: ";
//            String rru_1800_answer = "На базовой станции, к которой подключается ваш номер, ведутся работы по улучшению качества связи 4G. Сроки выполнения работ: ";
//            String lte_upgrade_answer = "На базовой станции, к которой подключается ваш номер, ведутся работы по установке оборудования для работы сети 4G (LTE). Ожидаемые сроки: ";
//            String dual_beam_answer = "Рядом с указанными координатами запланированы работы по добавлению DualBeam антенн(LTE). Ожидаемые сроки: ";
//            String gu_upgrade_answer = "На базовой станции, к которой подключается ваш номер, ведутся работы по установке оборудования для работы сети 2G/3G. Ожидаемые сроки:";
//            String noCoverage_answer = "Для разрузки и улучшения качества связи (голос, интернет)по вашему адресу запланировано строительство новой базовой станции. Ожидаемые сроки запуска:";
//            String interference_answer = "По вашему адресу наблюдаются  помехи, связанные с внешними факторами,  независящими от Компании. Наши специалисты ведут переговоры по улучшению ситуации. Ожидаемые сроки устранения проблем:";
//            String not_in_rollout = "В текущем плане покрытие не рассмотрено";
//            Answer same = command.near(lat, lon);
//            Date dateNow = new Date();
//            Date sdate = new java.sql.Date(dateNow.getTime());
//            Date date;
//            Date newDate;
//            java.sql.Date sdate3;
//            String repeated;
//            Answer newAnswer;
//            UserRep userRep;
//            java.sql.Date sdate2;
//            if (BTS_setU.isEmpty() && BTS_setG.isEmpty() && BTS_setL.isEmpty() && dismantled == null && planned_bs == null) {
//                solution_type = "NotInRollout";
//                date = new Date();
//                sdate2 = new java.sql.Date(date.getTime());
//                newDate = DateUtils.addMonths(new Date(), month);
//                sdate3 = new java.sql.Date(newDate.getTime());
//                repeated = "0";
//                newAnswer = new Answer(phone_number, request, not_in_rollout, lat, id, lon, id, sdate2);
//                userRep = new UserRep();
//                userRep.addAnswer(newAnswer, id);
//                userRep.addAnswerDB(request, solution_type, sdate3, sdate2, bts_name, LatLon, phone_number, polygon.Coordinate_city(latitude, longitude), user.getEmail(), user.getGroup(), type, lat, lon, repeated);
//            } else if (same != null && sdate.compareTo(same.getDateAnsw()) <= 0) {
//                String uzhe = "По указанным координатам раннее предоставлялся ответ: ";
//                if (!same.getAnswer_type().equals("aut_4G") && !same.getDateAnsw().equals("aut_3G")) {
//                    if (same.getAnswer_type().equals("alarm")) {
//                        answer = uzhe + alarms_answer + bts_name;
//                    } else if (same.getAnswer_type().equals("gu_upgrade")) {
//                        month = 3;
//                        answer = uzhe + gu_upgrade_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("interference")) {
//                        month = 2;
//                        answer = uzhe + interference_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("dismantled")) {
//                        month = 4;
//                        answer = uzhe + dismantled_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("rru_2100")) {
//                        month = 3;
//                        answer = uzhe + rru_2100_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("rru_900")) {
//                        month = 3;
//                        answer = uzhe + rru_900_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("rru_1800")) {
//                        month = 3;
//                        answer = uzhe + rru_1800_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("plan")) {
//                        month = 4;
//                        answer = uzhe + noCoverage_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("lte_upgrade")) {
//                        month = 3;
//                        answer = uzhe + lte_upgrade_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("transport")) {
//                        month = 3;
//                        answer = uzhe + transport_answer + month + " месяца";
//                    } else if (same.getAnswer_type().equals("dual_beam")) {
//                        month = 3;
//                        answer = uzhe + dual_beam_answer + month + " месяца";
//                    } else {
//                        answer = no_answer;
//                    }
//                } else {
//                    month = 4;
//                    answer = uzhe + aut_answer + month + " месяца";
//                }
//
//                date = new Date();
//                sdate3 = new java.sql.Date(date.getTime());
//                newDate = DateUtils.addMonths(new Date(), month);
//                sdate2 = new java.sql.Date(newDate.getTime());
//                newAnswer = new Answer(phone_number, request, answer, lat, id, lon, id, sdate2);
//                userRep = new UserRep();
//                userRep.addAnswer(newAnswer, id);
//                solution_type = same.getAnswer_type();
//                repeated = "1";
//                bts_name = same.getLatitude();
//                userRep.addAnswerDB(request, solution_type, sdate2, sdate3, bts_name, LatLon, phone_number, polygon.Coordinate_city(latitude, longitude), user.getEmail(), user.getGroup(), type, lat, lon, repeated);
//            } else {
//                byte var77 = -1;
//                switch (type.hashCode()) {
//                    case 2160:
//                        if (type.equals("D4")) {
//                            var77 = 3;
//                        }
//                        break;
//                    case 66949:
//                        if (type.equals("D23")) {
//                            var77 = 7;
//                        }
//                        break;
//                    case 75660:
//                        if (type.equals("LS3")) {
//                            var77 = 1;
//                        }
//                        break;
//                    case 75661:
//                        if (type.equals("LS4")) {
//                            var77 = 2;
//                        }
//                        break;
//                    case 79442:
//                        if (type.equals("Q23")) {
//                            var77 = 8;
//                        }
//                        break;
//                    case 2345512:
//                        if (type.equals("LS34")) {
//                            var77 = 0;
//                        }
//                        break;
//                    case 2433880:
//                        if (type.equals("None")) {
//                            var77 = 5;
//                        }
//                        break;
//                    case 2463683:
//                        if (type.equals("PR23")) {
//                            var77 = 6;
//                        }
//                        break;
//                    case 76374225:
//                        if (type.equals("PR234")) {
//                            var77 = 4;
//                        }
//                }
//
//                switch (var77) {
//                    case 0:
//                        if (alarms != null) {
//                            solution_type = "alarm";
//                            bts_name = alarms.getBts_name();
//                            answer = alarms_answer + " " + alarms.getAlarm_name() + " " + bts_name;
//                        } else if (transport != null) {
//                            month = 3;
//                            solution_type = "transport";
//                            bts_name = transport;
//                            answer = transport_answer + " " + month + " месяца";
//                        } else if (interferedL != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedL;
//                            solution_type = "interference";
//                        } else if (interferedU != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedU;
//                            solution_type = "interference";
//                        } else if (planned_bs != null) {
//                            month = 4;
//                            answer = noCoverage_answer + " " + month + " месяца";
//                            bts_name = planned_bs;
//                            solution_type = "plan";
//                        } else if (lte_upgrade != null) {
//                            month = 3;
//                            answer = lte_upgrade_answer + " " + month + " месяца";
//                            bts_name = lte_upgrade;
//                            solution_type = "lte_upgrade";
//                        } else if (dualbeam != null) {
//                            month = 3;
//                            answer = dual_beam_answer + " " + month + " месяца";
//                            bts_name = dualbeam;
//                            solution_type = "dual_beam";
//                        } else if (rru_1800 != null) {
//                            month = 3;
//                            answer = rru_1800_answer + " " + month + " месяца";
//                            bts_name = rru_1800;
//                            solution_type = "rru_1800";
//                        } else if (rru_900 != null) {
//                            month = 3;
//                            answer = rru_900_answer + " " + month + " месяца";
//                            bts_name = rru_900;
//                            solution_type = "rru_900";
//                        } else if (rru_2100 != null) {
//                            month = 3;
//                            answer = rru_2100_answer + " " + month + " месяца";
//                            bts_name = rru_2100;
//                            solution_type = "rru_2100";
//                        } else if (gu_upgrade != null) {
//                            month = 3;
//                            answer = gu_upgrade_answer + " " + month + " месяца";
//                            bts_name = gu_upgrade;
//                            solution_type = "gu_upgrade";
//                        } else if (aut4G != null) {
//                            month = 4;
//                            answer = aut_answer + " " + month + " месяца";
//                            bts_name = aut4G;
//                            solution_type = "aut_4G";
//                        } else if (aut3G != null) {
//                            month = 4;
//                            answer = aut_answer + " " + month + " месяца";
//                            bts_name = aut3G;
//                            solution_type = "aut_3G";
//                        } else if (dismantled != null) {
//                            month = 4;
//                            answer = dismantled_answer + " " + month + " месяца";
//                            bts_name = dismantled;
//                            solution_type = "dismantled";
//                        } else {
//                            answer = no_answer;
//                            solution_type = "noanswer";
//                        }
//                        break;
//                    case 1:
//                        if (alarms != null) {
//                            solution_type = "alarm";
//                            bts_name = alarms.getBts_name();
//                            answer = alarms_answer + " " + alarms.getAlarm_name() + " " + bts_name;
//                        } else if (transport != null) {
//                            month = 3;
//                            solution_type = "transport";
//                            bts_name = transport;
//                            answer = transport_answer + " " + month + " месяца";
//                        } else if (interferedU != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedU;
//                            solution_type = "interference";
//                        } else if (rru_900 != null) {
//                            month = 3;
//                            answer = rru_900_answer + " " + month + " месяца";
//                            bts_name = rru_900;
//                            solution_type = "rru_900";
//                        } else if (rru_2100 != null) {
//                            month = 3;
//                            answer = rru_2100_answer + " " + month + " месяца";
//                            bts_name = rru_2100;
//                            solution_type = "rru_2100";
//                        } else if (gu_upgrade != null) {
//                            month = 3;
//                            answer = gu_upgrade_answer + " " + month + " месяца";
//                            bts_name = gu_upgrade;
//                            solution_type = "gu_upgrade";
//                        } else if (aut3G != null) {
//                            month = 4;
//                            answer = aut_answer + " " + month + " месяца";
//                            bts_name = aut3G;
//                            solution_type = "aut_3G";
//                        } else if (dismantled != null) {
//                            month = 4;
//                            answer = dismantled_answer + " " + month + " месяца";
//                            bts_name = dismantled;
//                            solution_type = "dismantled";
//                        } else {
//                            answer = no_answer;
//                            solution_type = "noanswer";
//                        }
//                        break;
//                    case 2:
//                    case 3:
//                        if (alarms != null) {
//                            solution_type = "alarm";
//                            bts_name = alarms.getBts_name();
//                            answer = alarms_answer + " " + alarms.getAlarm_name() + " " + bts_name;
//                        } else if (transport != null) {
//                            month = 3;
//                            solution_type = "transport";
//                            bts_name = transport;
//                            answer = transport_answer + " " + month + " месяца";
//                        } else if (interferedL != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedL;
//                            solution_type = "interference";
//                        } else if (lte_upgrade != null) {
//                            month = 3;
//                            answer = lte_upgrade_answer + " " + month + " месяца";
//                            bts_name = lte_upgrade;
//                            solution_type = "lte_upgrade";
//                        } else if (dualbeam != null) {
//                            month = 3;
//                            answer = dual_beam_answer + " " + month + " месяца";
//                            bts_name = dualbeam;
//                            solution_type = "dual_beam";
//                        } else if (rru_1800 != null) {
//                            month = 3;
//                            answer = rru_1800_answer + " " + month + " месяца";
//                            bts_name = rru_1800;
//                            solution_type = "rru_1800";
//                        } else if (dismantled != null) {
//                            month = 4;
//                            answer = dismantled_answer + " " + month + " месяца";
//                            bts_name = dismantled;
//                            solution_type = "dismantled";
//                        } else {
//                            answer = no_answer;
//                            solution_type = "noanswer";
//                        }
//                        break;
//                    case 4:
//                    case 5:
//                        if (alarms != null) {
//                            solution_type = "alarm";
//                            bts_name = alarms.getBts_name();
//                            answer = alarms_answer + " " + alarms.getAlarm_name() + " " + bts_name;
//                        } else if (transport != null) {
//                            month = 3;
//                            solution_type = "transport";
//                            bts_name = transport;
//                            answer = transport_answer + " " + month + " месяца";
//                        } else if (interferedG != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedG;
//                            solution_type = "interference";
//                        } else if (interferedL != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedL;
//                            solution_type = "interference";
//                        } else if (interferedU != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedU;
//                            solution_type = "interference";
//                        } else if (planned_bs != null) {
//                            month = 4;
//                            answer = noCoverage_answer + " " + month + " месяца";
//                            bts_name = planned_bs;
//                            solution_type = "plan";
//                        } else if (lte_upgrade != null) {
//                            month = 3;
//                            answer = lte_upgrade_answer + " " + month + " месяца";
//                            bts_name = lte_upgrade;
//                            solution_type = "lte_upgrade";
//                        } else if (dualbeam != null) {
//                            month = 3;
//                            answer = dual_beam_answer + " " + month + " месяца";
//                            bts_name = dualbeam;
//                            solution_type = "dual_beam";
//                        } else if (rru_1800 != null) {
//                            month = 3;
//                            answer = rru_1800_answer + " " + month + " месяца";
//                            bts_name = rru_1800;
//                            solution_type = "rru_1800";
//                        } else if (rru_900 != null) {
//                            month = 3;
//                            answer = rru_900_answer + " " + month + " месяца";
//                            bts_name = rru_900;
//                            solution_type = "rru_900";
//                        } else if (rru_2100 != null) {
//                            month = 3;
//                            answer = rru_2100_answer + " " + month + " месяца";
//                            bts_name = rru_2100;
//                            solution_type = "rru_2100";
//                        } else if (gu_upgrade != null) {
//                            month = 3;
//                            answer = gu_upgrade_answer + " " + month + " месяца";
//                            bts_name = gu_upgrade;
//                            solution_type = "gu_upgrade";
//                        } else if (aut4G != null) {
//                            month = 4;
//                            answer = aut_answer + " " + month + " месяца";
//                            bts_name = aut4G;
//                            solution_type = "aut_4G";
//                        } else if (aut3G != null) {
//                            month = 4;
//                            answer = aut_answer + " " + month + " месяца";
//                            bts_name = aut3G;
//                            solution_type = "aut_3G";
//                        } else if (dismantled != null) {
//                            month = 4;
//                            answer = dismantled_answer + " " + month + " месяца";
//                            bts_name = dismantled;
//                            solution_type = "dismantled";
//                        } else {
//                            answer = no_answer;
//                            solution_type = "noanswer";
//                        }
//                        break;
//                    case 6:
//                    case 7:
//                    case 8:
//                        if (alarms != null) {
//                            solution_type = "alarm";
//                            bts_name = alarms.getBts_name();
//                            answer = alarms_answer + " " + alarms.getAlarm_name() + " " + bts_name;
//                        } else if (transport != null) {
//                            month = 3;
//                            solution_type = "transport";
//                            bts_name = transport;
//                            answer = transport_answer + " " + month + " месяца";
//                        } else if (interferedG != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedG;
//                            solution_type = "interference";
//                        } else if (interferedU != null) {
//                            month = 2;
//                            answer = interference_answer + " " + month + " месяца";
//                            bts_name = interferedU;
//                            solution_type = "interference";
//                        } else if (planned_bs != null) {
//                            month = 4;
//                            answer = noCoverage_answer + " " + month + " месяца";
//                            bts_name = planned_bs;
//                            solution_type = "plan";
//                        } else if (rru_900 != null) {
//                            month = 3;
//                            answer = rru_900_answer + " " + month + " месяца";
//                            bts_name = rru_900;
//                            solution_type = "rru_900";
//                        } else if (rru_2100 != null) {
//                            month = 3;
//                            answer = rru_2100_answer + " " + month + " месяца";
//                            bts_name = rru_2100;
//                            solution_type = "rru_2100";
//                        } else if (aut3G != null) {
//                            month = 4;
//                            answer = aut_answer + " " + month + " месяца";
//                            bts_name = aut3G;
//                            solution_type = "aut_3G";
//                        } else if (dismantled != null) {
//                            month = 4;
//                            answer = dismantled_answer + " " + month + " месяца";
//                            bts_name = dismantled;
//                            solution_type = "dismantled";
//                        } else {
//                            answer = no_answer;
//                            solution_type = "noanswer";
//                        }
//                }
//
//                date = new Date();
//                sdate2 = new java.sql.Date(date.getTime());
//                newDate = DateUtils.addMonths(new Date(), month);
//                sdate3 = new java.sql.Date(newDate.getTime());
//                repeated = "0";
//                newAnswer = new Answer(phone_number, request, answer, lat, id, lon, id, sdate2);
//                userRep = new UserRep();
//                userRep.addAnswer(newAnswer, id);
//                userRep.addAnswerDB(request, solution_type, sdate3, sdate2, bts_name, LatLon, phone_number, polygon.Coordinate_city(latitude, longitude), user.getEmail(), user.getGroup(), type, lat, lon, repeated);
//            }
//
//            ArrayList<String> secretAnswer = new ArrayList();
//            if (user.getGroup().equals("performance")) {
//                if (alarms != null) {
//                    secretAnswer.add(alarms.getBts_name() + " " + alarms.getAlarm_name());
//                }
//
//                if (planned_bs != null) {
//                    secretAnswer.add(planned_bs + " rru 900");
//                }
//
//                if (gu_upgrade != null) {
//                    secretAnswer.add(gu_upgrade + " gu upgrade");
//                }
//
//                if (rru_1800 != null) {
//                    secretAnswer.add(rru_1800 + " rru 1800");
//                }
//
//                if (rru_2100 != null) {
//                    secretAnswer.add(rru_2100 + " rru 2100");
//                }
//
//                if (rru_900 != null) {
//                    secretAnswer.add(rru_900 + " rru 900");
//                }
//
//                if (interferedG != null) {
//                    secretAnswer.add(interferedG + " interferedG");
//                }
//
//                if (interferedU != null) {
//                    secretAnswer.add(interferedU + " interferedU");
//                }
//
//                if (interferedL != null) {
//                    secretAnswer.add(interferedL + " interferedL");
//                }
//
//                if (aut3G != null) {
//                    secretAnswer.add(aut3G + " aut3G");
//                }
//
//                if (aut4G != null) {
//                    secretAnswer.add(aut4G + " aut4G");
//                }
//
//                if (dismantled != null) {
//                    secretAnswer.add(dismantled + " dismantled");
//                }
//
//                if (dualbeam != null) {
//                    secretAnswer.add(dualbeam + " dismantled");
//                }
//
//                if (transport_detail != null) {
//                    secretAnswer.add(transport_detail.getSite_name() + " " + transport_detail.getComment());
//                }
//
//                if(mocnOptimization != null){
//                    secretAnswer.add(mocnOptimization.getSite()+" " + mocnOptimization.getComment());
//                }
//            } else if (transport_detail != null) {
//                secretAnswer.add(transport_detail.getSite_name() + " " + transport_detail.getComment());
//
//            }else if(mocnOptimization !=null){
//                secretAnswer.add(mocnOptimization.getSite()+" " + mocnOptimization.getComment());
//            }
//
//            req.setAttribute("secretAnswers", secretAnswer);
//            req.getRequestDispatcher("index.jsp").forward(req, resp);
//        }
//
//    }
//}
