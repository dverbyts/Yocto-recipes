DESCRIPTION = "HTMLDOC converts HTML input files into indexed HTML, postscript or PDF files"
HOMEPAGE = "https://www.msweet.org/htmldoc"
SECTION = "console/utils"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += " \
    libpng \
    jpeg \
    zlib \
    freetype \
    openssl \
    cups \
    "

SRC_URI = " \
    git://github.com/michaelrsweet/htmldoc.git;protocol=https;tag=v1.9.17 \
    file://001-remove-docs-from-build.patch \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_AUTORECONF += " --exclude=autoheader"
EXTRA_OECONF += " --with-gui=no --disable-static"

do_compile_prepend() {
    cp -rfu ${B}/* ${S}/
    cd ${S}
}

do_install() {
	install -d ${D}${datadir}/htmldoc/fonts
	install -m 0644 ${S}/fonts/*.afm ${D}${datadir}/htmldoc/fonts/
	install -m 0644 ${S}/fonts/*.pfa ${D}${datadir}/htmldoc/fonts/

	install -d ${D}${datadir}/htmldoc/data
	install -m 0644 ${S}/data/* ${D}${datadir}/htmldoc/data/

	install -d ${D}${bindir}
	install -m 0755 ${S}/htmldoc/htmldoc ${D}${bindir}/
}

FILES_${PN} += " \
    ${datadir}/htmldoc/fonts \
    ${datadir}/htmldoc/data \
    "
