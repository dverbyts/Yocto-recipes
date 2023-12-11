DESCRIPTION = "Control X from the command line"
HOMEPAGE = "http://www.hoopajoo.net/projects/xautomation.html"
SECTION = "console"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://www.hoopajoo.net/static/projects/${BPN}-${PV}.tar.gz \
           file://remove-man.patch"

inherit autotools pkgconfig license

PR = "r0"

DEPENDS = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'libxi', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'libxtst', '', d)} \
    libpng \
"

SRC_URI[md5sum] = "16b973fdb525feed876471225bba30ed"
SRC_URI[sha256sum] = "ee8f2c61165da682f58371a51cfc263d6e54609b614e712320b0987779d95f0d"
