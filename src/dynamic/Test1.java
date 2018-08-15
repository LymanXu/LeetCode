package dynamic;

import java.util.*;

class Solution {

    class Tests{
        int id;
        String name;
    };
    class Runs{};

    // 查询所有的tests
    public List<Tests> listTests(){
        String sql = "select * from tests";

        // 模拟数据库查询
        List<Tests> resu = new ArrayList<>();
        return resu;
    }


    public List<Integer> getRunIdByTestId(int id){
        String sql = "select run_id from runs where test_id=?";

        List<Integer> resu = new ArrayList<>();
        return resu;
    }

    // 查询某种测试用例的运行情况
    class CassesResult{
        int pass_run_num;
        int fail_run_num;
        List<Casses> fail_cases;
    };
    class Casses{
        int id;
        int run_id;
        String status;
        Date start_time;
        Date end_time;
    };

    public CassesResult getCasesByRunId(int id){
        String sql = "select id, run_id, status from cases where run_id=?";

        // 模拟数据库查询

        List<Casses> resu = new ArrayList();
        int pass_run_num = 0;
        int fail_run_num = 0;
        List<Casses> fail_cases = new ArrayList<>();
        for(Casses temp: resu){
            if("fail".equals(temp.status) && pass_run_num == 0){
                pass_run_num = 1;
            }else if("fail".equals(temp.status)){
                fail_cases.add(temp);
            }
        }
        CassesResult CasesRe = new CassesResult();
        CasesRe.pass_run_num = pass_run_num;
        CasesRe.fail_run_num = fail_run_num;

        return CasesRe;

    }


    public void listResult(){
        // 单个测试可以呈现的结果
        ArrayList<Map<String, Object>> result = new ArrayList<>();

        Solution solu = new Solution();
        List<Tests> tests = solu.listTests();
        for(Tests aTest: tests){
            Map<String, Object> temp2Re = new HashMap<>();
            temp2Re.put("test_name", aTest.name);

            List<Integer> runIds = solu.getRunIdByTestId(aTest.id);

            int sum_pass_run_num = 0;
            int sum_fail_run_num = 0;
            List<Casses> sum_fail_case_list = new ArrayList<>();

            for(Integer runId : runIds){
                CassesResult cassesResu = solu.getCasesByRunId(aTest.id);
                sum_pass_run_num += cassesResu.pass_run_num;
                sum_fail_run_num +=  cassesResu.fail_run_num;
                sum_fail_case_list.addAll(cassesResu.fail_cases);
            }

            temp2Re.put("pass_run_num", sum_pass_run_num);
            temp2Re.put("fail_run_num", sum_fail_run_num);
            temp2Re.put("fail_case_list", sum_fail_case_list);
            result.add(temp2Re);

        }
        // JSONArray array = JSONArray.fromObject(result);
        //String jsonstr = Array.toString();
        //System.out.println(jsonstr);
    }
}
