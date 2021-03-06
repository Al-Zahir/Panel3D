package panel3d.Objects;

import java.awt.Color;
import org.jblas.*;
import java.util.List;
import java.util.Arrays;
import panel3d.GameObject;
import panel3d.RMath;

public class TriCube extends GameObject
{
    private DoubleMatrix points = RMath.PTDM(new double[][]{
            {1,1,1},
            {1,-1,1},
            {-1,1,1},
            {-1,-1,1},
            {1,1,-1},
            {1,-1,-1},
            {-1,1,-1},
            {-1,-1,-1}
    });
    private List<Integer> triangles = Arrays.asList(0,1,2,1,2,3,4,5,6,5,6,7,0,4,5,0,1,5,2,6,7,2,3,7,0,2,6,0,4,6,1,3,7,1,5,7);
    
    private double speed = 3;
    
    public TriCube()
    {
        mesh.points = points;
        mesh.triangles = triangles;
        drawMode = 1;
        
        for(int tri=0; tri < mesh.triangles.size(); tri += 3)
        {
            int a = (int) (90 * DoubleMatrix.ones(3).distance2(mesh.points.getColumn(mesh.triangles.get(tri)).add(
                                                               mesh.points.getColumn(mesh.triangles.get(tri+1)).add(
                                                               mesh.points.getColumn(mesh.triangles.get(tri+2)))).div(3)));
            mesh.triColor.add(new Color(a,a,a));
        }
    }
    
    public void OnFixedUpdate(double deltaTime)
    {
        super.OnFixedUpdate(deltaTime);
    }
}