package offer.amzon.oa;

/**
 * ClassName: NumOfBricks
 * Description:
 * date: 28/5/2022 上午11:53
 * Problem Statement:
 * John (1) and Jack (2), are friends who construct the wall as per the number of bricks given to them.
 * They work turn by turn. John works in the increasing order starting from 1 with an increment of 1. Jack places twice the bricks as John places in previous turn. Goal is to find who placed the last brick and how many bricks will be placed in the end.
 * Example 1:
 * numberOfBricks: 13
 * John & Jack will construct the wall
 * John 1
 * Total Bricks till now: 1
 * Jack 1 * 2
 * Total Bricks till now: 3
 * John 2
 * Total Bricks till now: 5
 * Jack 2 * 2
 * Total Bricks till now: 9
 * John 3
 * Total Bricks till now: 12
 * Jack 3 * 2
 * Total Bricks till now: 18
 * Since total bricks to be placed were 13. But lastly sum became 18, hence lastly Jack has to place on 1 more brick. The correct answer in result array is:
 * result[0] = 2 // as Jack placed the last brick
 * result[1] = 1 // only 1 brick was to be placed in the end
 * @author liyh
 */
public class NumOfBricks {
}

