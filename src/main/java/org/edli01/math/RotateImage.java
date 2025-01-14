package org.edli01.math;

/**
 * @Project: DataStructureAndAlgorithm
 * @Package: org.edli01.math
 * @Author: MENG-JUN LI
 * @CreateTime: 2024-10-13 23:37
 * @Instagram: https://www.instagram.com/edli_01
 * @Blog: https://edli-01.com/
 * @Description:
 **/
public class RotateImage {
    public void rotate(int[][] matrix) {
        //Matrix Constraints
        if(!checkContraintsIsOk(matrix)) {
            return;
        }

        int tempValue = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i != j && i < j) {
                    tempValue = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tempValue;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(i != j) {
                    tempValue = matrix[i][matrix.length-1-j];
                    matrix[i][matrix.length-1-j] = matrix[i][j];
                    matrix[i][j] = tempValue;
                }
            }
        }
        System.out.println("End.");
    }

    private boolean checkContraintsIsOk(int[][] matrix) {
        if(1 <= matrix.length && matrix.length <= 20) {
            for(int i = 0; i < matrix.length; i++) {
                if(matrix.length == matrix[i].length) {
                    for(int j = 0; j < matrix[i].length; j++)
                        if(!(-1000 <= matrix[i][j] && matrix[i][j] <= 1000)) {
                            return false;
                        }
                }else {
                    return false;
                }
            }

        }else {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ri.rotate(matrix);
    }
}
