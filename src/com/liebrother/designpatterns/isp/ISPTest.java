package com.liebrother.designpatterns.isp;

/**
 * @author wangjiaojiao
 * @since 2023/09/05
 */
public class ISPTest {
    /**
     * 不好的示范
     */
    //学生成绩
    public interface IStudentScore {
        // 查询成绩
        public void queryScore();

        // 修改成绩
        public void updateScore();

        // 添加成绩
        public void saveScore();

        // 删除成绩
        public void delete();

        // 计算总分
        public double sum();

        // 计算平均分
        public double avg();

        // 打印成绩单
        public void printScore();
    }

    //所有的功能都放在一个接口里面. 这会产生什么样的问题呢? 首先, 接口的方法很多, 不利于扩展.
    // 比如: 学生只有查看成绩,打印成绩单的权限, 没有增删改的权限; 老师拥有所有的权限.

    //查询成绩单:
    public class QueryScore implements IStudentScore{
        @Override
        public void queryScore() {
            // 查询成绩
        }

        @Override
        public void updateScore() {
            // 没有权限
        }

        @Override
        public void saveScore() {
            // 没有权限
        }

        @Override
        public void delete() {
            // 没有权限
        }

        @Override
        public double sum() {
            // 没有权限
            return 0;
        }

        @Override
        public double avg() {
            // 没有权限
            return 0;
        }

        @Override
        public void printScore() {
            //打印成绩单
        }
    }

    //操作成绩单
    public class Operate implements IStudentScore{
        @Override
        public void queryScore() {

        }

        @Override
        public void updateScore() {

        }

        @Override
        public void saveScore() {

        }

        @Override
        public void delete() {

        }

        @Override
        public double sum() {
            return 0;
        }

        @Override
        public double avg() {
            return 0;
        }

        @Override
        public void printScore() {

        }
    }

    //实现了接口, 不得不重写所有的方法.
    // 如果这时候增加需求--发送给家长, 只有老师才有这个权限, 学生没有这个权限.
    // 可是, 在接口中增加一个抽象方法以后, 所有的实现类都要重写这个方法. 这就违背了开闭原则.


    /**
     * 正确示范
     */
    public interface IQueryScore {
        // 查询成绩
        public void queryScore();

        // 打印成绩单
        public void printScore();
    }

    public interface IOperateScore {

        // 修改成绩
        public void updateScore();

        // 添加成绩
        public void saveScore();

        // 删除成绩
        public void delete();

        // 计算总分
        public double sum();

        // 计算平均分
        public double avg();

    }

    public class StudentOperate implements IQueryScore{
        @Override
        public void queryScore() {
            // 查询成绩
        }

        @Override
        public void printScore() {
            //打印成绩单
        }
    }


    public class TeacherOperate implements IQueryScore, IOperateScore{
        @Override
        public void queryScore() {

        }

        @Override
        public void updateScore() {

        }

        @Override
        public void saveScore() {

        }

        @Override
        public void delete() {

        }

        @Override
        public double sum() {
            return 0;
        }

        @Override
        public double avg() {
            return 0;
        }

        @Override
        public void printScore() {

        }
    }

    //将原来的一个接口进行了接口拆分. 分为查询接口和操作接口. 这样学生端就不需要重写和他不相关的接口了.
}
