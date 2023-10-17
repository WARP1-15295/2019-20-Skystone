/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.Autos.Red.BuildingZone;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotMap;

@Autonomous(name="Red Building Zone Foundation Pull Park Far", group="Red Building Zone")
//@Disabled
public class RedBuildingZoneFoundationPullParkFar extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    RobotMap robotMap = new RobotMap();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robotMap.init(hardwareMap);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP) //DONE
        while (opModeIsActive()) {
            robotMap.grabberLeftServo.setPosition(robotMap.GRABBER_RELEASE);
            robotMap.grabberLeftServo.setPosition(robotMap.GRABBER_RELEASE);
            robotMap.grabberRightServo.setPosition(robotMap.GRABBER_RELEASE);
            robotMap.hookLeftServo.setPosition(robotMap.HOOK_RELEASE);
            robotMap.hookRightServo.setPosition(robotMap.HOOK_RELEASE);
            robotMap.singleMotorRunToDistance(robotMap.drivetrainCenter, 13.5, 4.0);
            robotMap.dualMotorRunToDistance(robotMap.drivetrainLeft, robotMap.drivetrainRight, 35.0, 35.0, 0.7, 4.0);
            robotMap.hookLeftServo.setPosition(robotMap.HOOK_GRAB);
            robotMap.hookRightServo.setPosition(robotMap.HOOK_GRAB);
            sleep(1000);
            robotMap.dualMotorRunToDistance(robotMap.drivetrainLeft, robotMap.drivetrainRight, -60.0, -60.0, robotMap.MAX_AUTO_COURSE_POWER, 5.0);;
            robotMap.hookLeftServo.setPosition(robotMap.HOOK_RELEASE);
            robotMap.hookRightServo.setPosition(robotMap.HOOK_RELEASE);
            sleep(750);
            robotMap.dualMotorRunToDistance(robotMap.drivetrainLeft, robotMap.drivetrainRight, 3.0, 3.0, robotMap.MAX_AUTO_COURSE_POWER, 1.0);
            robotMap.dualMotorRunToDistance(robotMap.drivetrainLeft, robotMap.drivetrainRight, -1.5, -1.5, RobotMap.MAX_AUTO_COURSE_POWER, 1.0);
            robotMap.singleMotorRunToDistance(robotMap.drivetrainCenter, -30.0, 15.0);
            robotMap.dualMotorRunToDistance(robotMap.drivetrainLeft, robotMap.drivetrainRight, 22.0, 22.0, RobotMap.MAX_AUTO_COURSE_POWER, 5.0);
            robotMap.singleMotorRunToDistance(robotMap.drivetrainCenter, -26.0, 15.0);
            sleep(30000);
        }
    }
}
