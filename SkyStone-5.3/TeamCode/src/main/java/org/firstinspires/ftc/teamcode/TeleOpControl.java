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

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Driver Control Mode")
//@Disabled
public class TeleOpControl extends OpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    RobotMap robotMap = new RobotMap();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initializing");

        robotMap.init(hardwareMap);

        // Set the run mode to run without encoders
        robotMap.drivetrainLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robotMap.drivetrainCenter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robotMap.drivetrainRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robotMap.elevatorRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robotMap.elevatorLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        //GAMEPAD 1
        double course = -gamepad1.right_stick_y;
        double rotate = gamepad1.left_stick_x;
        double strafe = gamepad1.right_stick_x;

        if (Math.abs(rotate) > 0.1) {
            robotMap.drivetrainLeft.setPower(rotate);
            robotMap.drivetrainRight.setPower(-rotate);
        } else {
            robotMap.drivetrainLeft.setPower(course);
            robotMap.drivetrainRight.setPower(course);
        }

        robotMap.drivetrainCenter.setPower(strafe);

        //GAMEPAD 2
        double elevatorPower = -gamepad2.left_stick_y;

        if (Math.abs(elevatorPower) > 0.07) {
            robotMap.elevatorLeftMotor.setPower(elevatorPower);
            robotMap.elevatorRightMotor.setPower(elevatorPower);
        } else {
            robotMap.elevatorLeftMotor.setPower(0.0);
            robotMap.elevatorRightMotor.setPower(0.0);
        }


        if (gamepad2.a) {
            robotMap.grabberRightServo.setPosition(robotMap.GRABBER_RELEASE);
            robotMap.grabberLeftServo.setPosition(robotMap.GRABBER_RELEASE);
        } else if (gamepad2.x) {
            robotMap.grabberRightServo.setPosition(robotMap.GRABBER_CAPSTONE);
            robotMap.grabberLeftServo.setPosition(robotMap.GRABBER_CAPSTONE);
        } else {
            robotMap.grabberLeftServo.setPosition(robotMap.GRABBER_GRAB);
            robotMap.grabberRightServo.setPosition(robotMap.GRABBER_GRAB);
        }

        if (gamepad2.b) {
            robotMap.hookLeftServo.setPosition(robotMap.HOOK_GRAB);
            robotMap.hookRightServo.setPosition(robotMap.HOOK_GRAB);
        } else {
            robotMap.hookLeftServo.setPosition(robotMap.HOOK_RELEASE);
            robotMap.hookRightServo.setPosition(robotMap.HOOK_RELEASE);
        }

        if (gamepad2.y) {
            robotMap.deployServo.setPosition(robotMap.DEPLOY_DEPLOY);
        } else {
            robotMap.deployServo.setPosition(robotMap.DEPLOY_START);
        }


        // Show the elapsed game time
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
