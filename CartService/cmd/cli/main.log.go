package main

import (
	"os"

	"go.uber.org/zap"
	"go.uber.org/zap/zapcore"
)

func main() {
	// 1.
	// sugar := zap.NewExample().Sugar()

	// sugar.Infof("Hello name:%s, age:%d ", "Chien", 22) // like fmt.Printf(format, a)

	// // logger
	// logger := zap.NewExample()
	// logger.Info("Hello", zap.String("name", "ChienGo"), zap.Int("age", 22))

	// 2.
	// logger := zap.NewExample()
	// logger.Info("Hello")

	// // Development
	// logger, _ = zap.NewDevelopment()
	// logger.Info("Hello NewDevelopment")

	// // Production
	// logger, _ = zap.NewProduction()
	// logger.Info("Hello NewProduction")

	// 3.
	encoder := getEncoderLog()
	sync := getWriterSync()
	core := zapcore.NewCore(encoder, sync, zapcore.InfoLevel)
	logger := zap.New(core, zap.AddCaller())

	logger.Info("Info log", zap.Int("line", 1))
	logger.Error("Error log", zap.Int("line", 2))
}

// format log
func getEncoderLog() zapcore.Encoder {
	encodeConfig := zap.NewProductionEncoderConfig()

	// 1735998172.7846837 -> 2025-01-04T20:42:52.784+0700
	encodeConfig.EncodeTime = zapcore.ISO8601TimeEncoder

	// ts -> Time
	encodeConfig.TimeKey = "time"

	// from info -> INFO
	encodeConfig.EncodeLevel = zapcore.CapitalLevelEncoder

	// "caller":"cli/main.log.go:23"
	encodeConfig.EncodeCaller = zapcore.ShortCallerEncoder // zao.Ne

	return zapcore.NewJSONEncoder(encodeConfig)
}

func getWriterSync() zapcore.WriteSyncer {
	file, _ := os.OpenFile("./log/log.txt", os.O_CREATE|os.O_WRONLY, os.ModePerm)
	syncFile := zapcore.AddSync(file)
	syncConsole := zapcore.AddSync(os.Stderr)
	return zapcore.NewMultiWriteSyncer(syncConsole, syncFile)
}
